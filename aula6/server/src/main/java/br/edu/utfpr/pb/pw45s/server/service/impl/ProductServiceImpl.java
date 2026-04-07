package br.edu.utfpr.pb.pw45s.server.service.impl;

import br.edu.utfpr.pb.pw45s.server.model.Product;
import br.edu.utfpr.pb.pw45s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw45s.server.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
@Slf4j
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {
    private static final String FILE_PATH = "upload";
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return this.productRepository;
    }

    @Override
    public void saveImageFileToDisk(MultipartFile file, Product product) {
        File dir = new File(FILE_PATH + File.separator + "images");
        if (!dir.exists()) {
            dir.mkdir();
        }
        String suffix = Objects.requireNonNull(file.getOriginalFilename())
                                .substring(
                                        file.getOriginalFilename()
                                                .lastIndexOf("."));
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    new File(dir + File.separator + product.getId() + suffix)
            );
            BufferedOutputStream out = new BufferedOutputStream(fileOut);
            out.write(file.getBytes());
            out.close();
            fileOut.close();

            product.setImageFileName(product.getId() + suffix);
            productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveImageFileToDatabase(MultipartFile file, Product product) {
        try {
            String suffix = Objects.requireNonNull(file.getOriginalFilename())
                    .substring(
                            file.getOriginalFilename()
                                    .lastIndexOf("."));
            product.setImageFileName(product.getId() + suffix);
            product.setImageFile(file.getBytes());
            productRepository.save(product);
        }   catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getProductImageFileFromDisk(Long id) {
        try {
            Product product = productRepository.findById(id).orElse(null);
            if (product == null) {
                throw new RuntimeException("Product with id: " + id + " not found");
            }
            String fileName = FILE_PATH + File.separator + "images"
                                + File.separator + product.getImageFileName();
            return encodedFileToBase64(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String encodedFileToBase64(String file) throws IOException {
        File fileOut = new File(file);
        FileInputStream stream = new FileInputStream(fileOut);
        byte[] encoded = Base64.encodeBase64(IOUtils.toByteArray(stream));
        stream.close();
        return new String(encoded, StandardCharsets.US_ASCII);
    }
}
