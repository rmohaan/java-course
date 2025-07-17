package org.mohaan.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mohaan.entities.Products;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderInformation {
    private Integer id;
    @NotNull
    @NotEmpty
    private List<Products> products;
    private double totalPrice;
}
