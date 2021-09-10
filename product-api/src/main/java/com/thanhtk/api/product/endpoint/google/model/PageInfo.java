package com.thanhtk.api.product.endpoint.google.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private float totalResults;
    private float resultsPerPage;
}
