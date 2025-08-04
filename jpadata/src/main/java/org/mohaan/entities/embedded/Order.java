package org.mohaan.entities.embedded;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders", schema = "tutorials")
public class Order {

    @EmbeddedId
    private OrderId orderId;

    private String productName;

    private Integer quantity;

    private Double price;
}
