package org.mohaan;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.spec.MGF1ParameterSpec;

public class RSAEncryptionService {

    private PrivateKey loadPrivateKey(String resourcePath) throws Exception {
        byte[] keyBytes;
        try {
            keyBytes = Files.readAllBytes(Paths.get(resourcePath));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read private key file: " + resourcePath, e);
        }

        String privateKeyPEM = new String(keyBytes).trim()
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public String decrypt(String encryptedPayloadBase64, String privateKeyResourcePath) throws Exception {
        PrivateKey privateKey = loadPrivateKey(privateKeyResourcePath);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPayloadBase64);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");

        var mgf1Spec = new MGF1ParameterSpec("SHA-256");
        OAEPParameterSpec oaepParams = new OAEPParameterSpec(
                "SHA-256",
                "MGF1",
                mgf1Spec,
                PSource.PSpecified.DEFAULT
        );
        cipher.init(Cipher.DECRYPT_MODE, privateKey, oaepParams);

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}

