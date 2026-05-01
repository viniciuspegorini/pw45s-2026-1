package br.edu.utfpr.pb.pw45s.server.security.social;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class GoogleTokenVerifier {
    private static final HttpTransport httpTransport =
            new NetHttpTransport();
    private static final JsonFactory jsonFactory =
            GsonFactory.getDefaultInstance();
    private static final String CLIENT_ID = "310109923674-66b8cemcsb8jepvjceruatgju3613290.apps.googleusercontent.com";

    public JsonWebToken.Payload verify(String idTokenString) {
        return GoogleTokenVerifier.verifyToken(idTokenString);
    }

    public static JsonWebToken.Payload verifyToken(String idTokenString) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
                .Builder(httpTransport, jsonFactory)
                .setIssuers(Arrays.asList("https://accounts.google.com",
                        "accounts.google.com"))
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if  (idToken == null) {
            throw new RuntimeException("Google idToken is invalid");
        }
        return idToken.getPayload();
    }
}
