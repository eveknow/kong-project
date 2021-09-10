package com.thanhtk.api.product.endpoint.google.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private String viewCount;
    private String subscriberCount;
    private boolean hiddenSubscriberCount;
    private String videoCount;
}
