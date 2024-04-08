package com.teamproject1.scuoledevelhope.config;


import com.bananapilot.samplespringauthenticationframework.config.SampleSpringAuthenticationFrameworkConfig;
import com.teamproject1.scuoledevelhope.util.FloorLeveImplInternal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SampleSpringAuthenticationFrameworkConfig.class)
public class ScuoleDevelhopeApplicationConfig {

    @Bean
    public FloorLeveImplInternal floorLeveImplInternal() {
        return new FloorLeveImplInternal();
    }
}
