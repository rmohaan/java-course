package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Lecture;
import org.mohaan.models.LectureDto;

@Mapper(componentModel = "spring")
public interface LectureMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Lecture toEntity(LectureDto lectureDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    LectureDto toModel(Lecture lecture);

}
