package org.mohaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResilienceSample {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ResilienceSample.class, args);
        RSAEncryptionService rsaEncryptionService = new RSAEncryptionService();
        String encryptedText = "0cpyfohTvGzC3/QiQQ4pBv7lVDw+7iHyntvHxlTQ4Ov9afoJpUiOUfjiXw/gVrk58FdUjzTDkVQBBuZsbdj/pEP+HMLQWPJKEWi32mBDQYzFLg86UD88qKFhALsPfxtL2yk/RkrCK9GGdIDydwQFZ/SBs6V+mAjbf8xBfX7sCD1fgCRncSui6BS6xnmFfD4XS1YozCCgrK0kVmCLGGQnS3/FYmKL81kiG2WjLkjA49a/JQD+RdTPZysX2E1P40VWSiQA7S8ZXhycfeQ2D/rWkACS0WGelwMVjWt2grGJizbekF8amDUCwd5gWvKwSRLc0YRgBk7YA8WCNtFdB6OERQ==";
        String val = rsaEncryptionService.decrypt(encryptedText, "/Users/nkrishnakumar/IdeaProjects/jcourse/resilienceSample/src/main/resources/private_key_pkcs8.pem");
        System.out.println("Decrypted Value: " + val);
    }
}
