package br.edu.utfpr.pb.pw45s.server.controller;

import br.edu.utfpr.pb.pw45s.server.dto.ProductDto;
import br.edu.utfpr.pb.pw45s.server.model.Product;
import br.edu.utfpr.pb.pw45s.server.service.CrudService;
import br.edu.utfpr.pb.pw45s.server.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("products")
public class ProductController extends CrudController<Product, ProductDto, Long> {

    private final ProductService productService;
    private final ModelMapper modelMapper;


    public ProductController(ProductService productService, ModelMapper modelMapper) {
        super(Product.class, ProductDto.class);
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected CrudService<Product, Long> getService() {
        return this.productService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @PostMapping("upload-fs")
    public ResponseEntity<Product> uploadFs(
            @RequestPart("image") MultipartFile file,
            @RequestPart("product") @Valid Product product) {
        productService.saveImageFileToDisk(file, product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("upload-db")
    public ResponseEntity<Product> uploadDb(
            @RequestPart("image") MultipartFile file,
            @RequestPart("product") @Valid Product product) {
        productService.saveImageFileToDatabase(file, product);
        return ResponseEntity.ok(product);
    }
}
