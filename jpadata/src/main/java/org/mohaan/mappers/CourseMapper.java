package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Author;
import org.mohaan.entities.Course;
import org.mohaan.models.CourseDto;

@Mapper( componentModel = "spring", uses = Author.class)
public interface CourseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "authors", source = "authors")
    Course toEntity(CourseDto course);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "authors", source = "authors")
    CourseDto toModel(Course course);

}
