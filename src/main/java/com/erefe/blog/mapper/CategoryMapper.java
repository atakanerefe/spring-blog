package com.erefe.blog.mapper;

import com.erefe.blog.entity.Category;
import com.erefe.blog.request.CategoryRequest;
import com.erefe.blog.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    // Ignore ID when converting from request → entity (it will be auto-generated)
    Category toEntity(CategoryRequest dto);

    // Simple conversion entity → response
    CategoryResponse toResponse(Category entity);
}
