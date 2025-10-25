package com.erefe.blog.request;

import jakarta.validation.constraints.NotEmpty;

public class CategoryRequest {

    @NotEmpty
    private String name;
    private String description;
}
