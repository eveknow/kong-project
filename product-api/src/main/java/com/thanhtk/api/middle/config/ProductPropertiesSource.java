package com.thanhtk.api.middle.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:product-api.properties")
public class ProductPropertiesSource {
}
