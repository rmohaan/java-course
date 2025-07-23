package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Course;
import org.mohaan.models.CourseDto;

@Mapper( componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    Course toEntity(CourseDto course);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    CourseDto toModel(Course course);

}
