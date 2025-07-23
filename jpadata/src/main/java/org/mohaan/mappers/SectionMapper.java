package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Section;
import org.mohaan.models.SectionDto;

@Mapper
public interface SectionMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "sectionOrder", source = "sectionOrder")
    Section toEntity(SectionDto sectionDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "sectionOrder", source = "sectionOrder")
    SectionDto toModel(Section section);
}
