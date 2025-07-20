package org.mohaan;

import org.mohaan.model.Author;
import org.mohaan.service.EnvironmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Main.class, args);

        //Author author = new Author("Mohaan", "Raja");
        var env = ctx.getBean(EnvironmentService.class);
//        System.out.println(env.getNameProperty());
//        System.out.println(env.getCustomProperty());
//        System.out.println(env.getJavaVersion());
//        System.out.println(author.getPenName());
    }
}