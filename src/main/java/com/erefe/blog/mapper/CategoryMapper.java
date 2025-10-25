package com.erefe.blog.mapper;


import com.erefe.blog.entity.Category;
import com.erefe.blog.request.CategoryRequest;
import com.erefe.blog.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryRequest dto);
    CategoryResponse toResponse(Category entity);
}
