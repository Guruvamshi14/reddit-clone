package com.reddit.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dea2b83gj",
                "api_key", "495534623496618",
                "api_secret", "AzcDc0EpcmYi15FFGxPP_CfiBoA",
                "secure", true
        ));
    }
}
