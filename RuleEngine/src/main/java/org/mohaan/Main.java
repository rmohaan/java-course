package org.mohaan;

public class Main {
    public static void main(String[] args) {
        File file = new File();

        Validator validator = new Validator(
                                    L1Validation::validate,
                                    L2Validation::validate
                              );
        validator.validateFile(file);
    }
}