package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Author;
import org.mohaan.entities.Course;
import org.mohaan.entities.embedded.Address;
import org.mohaan.models.AuthorDto;

@Mapper(componentModel="spring", uses = {Course.class, Address.class})
public interface AuthorMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "courses", source = "courses")
    @Mapping(target = "address", source = "address")
    Author toEntity(AuthorDto author);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "courses", source = "courses")
    @Mapping(target = "address", source = "address")
    AuthorDto toModel(Author author);

}
