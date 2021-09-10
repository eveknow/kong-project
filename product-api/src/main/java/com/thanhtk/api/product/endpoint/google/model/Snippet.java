package com.thanhtk.api.product.endpoint.google.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Snippet {
    String title;
    private String description;
    private String publishedAt;
    Object ThumbnailsObject;
    Object LocalizedObject;
    private String country;
}
