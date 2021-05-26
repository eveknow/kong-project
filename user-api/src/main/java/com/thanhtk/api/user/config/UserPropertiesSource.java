package com.thanhtk.api.user.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:user-api.properties")
public class UserPropertiesSource {
}
