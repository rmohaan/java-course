package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Author;
import org.mohaan.models.AuthorDto;

@Mapper(componentModel="spring")
public interface AuthorMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "age", source = "age")
    Author toEntity(AuthorDto author);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "age", source = "age")
    AuthorDto toModel(Author author);

}
