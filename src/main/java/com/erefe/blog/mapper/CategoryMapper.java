package com.erefe.blog.mapper;


import com.erefe.blog.entity.Category;
import com.erefe.blog.request.CategoryRequest;
import com.erefe.blog.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequest dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CategoryResponse toResponse(Category entity);
}
