package com.erefe.blog.mapper;

import com.erefe.blog.entity.Post;
import com.erefe.blog.request.PostRequest;
import com.erefe.blog.response.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "categoryName",
            expression = "java(post.getCategory() != null ? post.getCategory().getName() : null)")
    PostResponse toResponse(Post post);

    Post toEntity(PostRequest postRequest);
}
