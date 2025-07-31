package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Resource;
import org.mohaan.models.ResourceDto;

@Mapper
public interface ResourceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Resource toEntity(ResourceDto resourceDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ResourceDto toModel(Resource resource);
}
