package com.thanhtk.api.product.endpoint.google.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeAnalyticsResponse {
    private String kind;
    ArrayList< YoutubeAnalyticsColumn > columnHeaders = new ArrayList < YoutubeAnalyticsColumn > ();
    ArrayList < Object > rows = new ArrayList < Object > ();

}
