package org.mohaan;

import java.util.function.Function;
import java.util.stream.Stream;

public class Validator {

    private Function<File, File> validate;

    @SafeVarargs
    public Validator(Function<File, File>... validate){
        this.validate = Stream.of(validate).reduce(Function.identity(), Function::andThen);
    }

    public File validateFile(File file) {
        return validate.apply(file);
    }
}
