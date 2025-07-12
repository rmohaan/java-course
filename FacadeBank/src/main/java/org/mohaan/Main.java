package org.mohaan;

import jakarta.annotation.PostConstruct;
import org.mohaan.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;

@SpringBootApplication
@ComponentScan("org.mohaan")
public class Main {

    @Autowired
    private BankService bankService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Camera cam = new Camera(Color::brighter);
        Camera cam2 = new Camera(Color::darker);
        System.out.println(cam.snap(new Color(125, 125, 125)));
        System.out.println(cam2.snap(new Color(125, 125, 125)));

    }

    @PostConstruct
    private void init() {
        if (bankService != null) {
            bankService.getAccountDetails("123456789");
            bankService.transferMoney("123456789", "876543", 46353653);
            bankService.depositMoney("123456789", 123456789);
        }
        else {
            System.out.println("The bank is getting intialized...");
        }
    }
}