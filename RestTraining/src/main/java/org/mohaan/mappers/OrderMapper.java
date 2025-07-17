package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Orders;
import org.mohaan.models.OrderInformation;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "products", target = "products")
    @Mapping(source = "totalPrice", target = "totalPrice")
    Orders toEntity(OrderInformation orderInformation);

    @Mapping(source = "products", target = "products")
    @Mapping(source = "totalPrice", target = "totalPrice")
    OrderInformation toModel(Orders orders);
}
