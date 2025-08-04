package org.mohaan;

import org.mohaan.entities.Author;
import org.mohaan.entities.embedded.Address;
import org.mohaan.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            var author = Author.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@gmail.com")
                    .age(30)
                    .address(
                            Address.builder()
                                    .street("Kambar Street")
                                    .city("Valluvan Illam")
                                    .state("Tamil Nadu")
                                    .zipCode("627001")
                                    .country("India")
                                    .build()
                    )
                    .createdAt(LocalDateTime.now())
                    .build();
            authorRepository.save(author);
        };
    }
}
