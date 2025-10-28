package com.erefe.blog.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private String categoryName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
