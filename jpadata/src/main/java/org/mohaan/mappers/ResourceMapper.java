package org.mohaan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mohaan.entities.Resource;
import org.mohaan.models.ResourceDto;

@Mapper
public interface ResourceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "size", source = "size")
    Resource toEntity(ResourceDto resourceDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "size", source = "size")
    ResourceDto toModel(Resource resource);
}
