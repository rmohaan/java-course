package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductInformation {
    private Integer id;
    private String name;
    private String description;
}
