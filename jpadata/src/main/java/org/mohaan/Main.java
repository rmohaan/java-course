package org.mohaan;

import com.github.javafaker.Faker;
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
            Faker faker;
            for (int i=0; i<10; i++) {
                faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .email(faker.internet().emailAddress())
                        .age(faker.number().numberBetween(20, 60))
                        .address(
                                Address.builder()
                                        .street(faker.address().streetName())
                                        .city(faker.address().city())
                                        .state(faker.address().state())
                                        .zipCode(faker.address().zipCode())
                                        .country(faker.address().country())
                                        .build()
                        )
                        .createdAt(LocalDateTime.now())
                        .build();
                authorRepository.save(author);
            }

//            var author = Author.builder()
//                    .firstName("John")
//                    .lastName("Doe")
//                    .email("john.doe@gmail.com")
//                    .age(30)
//                    .address(
//                            Address.builder()
//                                    .street("Kambar Street")
//                                    .city("Valluvan Illam")
//                                    .state("Tamil Nadu")
//                                    .zipCode("627001")
//                                    .country("India")
//                                    .build()
//                    )
//                    .createdAt(LocalDateTime.now())
//                    .build();
//            authorRepository.save(author);
        };
    }
}
