package org.mohaan.model;

import lombok.Data;

@Data
public class Book {
    String name;
    String ISBN;
    Author author;
}
