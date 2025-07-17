package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.mohaan.entities.Products;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderInformation {
    private Integer id;
    private List<Products> products;
    private double totalPrice;
}
