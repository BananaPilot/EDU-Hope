package com.teamproject1.scuoledevelhope.framework.config;


import com.bananapilot.samplespringauthenticationframework.config.SampleSpringAuthenticationFrameworkConfig;
import com.bananapilot.samplespringauthenticationframework.filtes.ExclusionPatterEvaluator;
import com.teamproject1.scuoledevelhope.framework.FloorLeveImplInternal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SampleSpringAuthenticationFrameworkConfig.class)
public class AuthorizationConfig {

    @Bean
    public FloorLeveImplInternal floorLeveImplInternal() {
        return new FloorLeveImplInternal();
    }

    @Bean
    public ExclusionPatterEvaluator exclusionPatterEvaluator() {
        return new ExclusionPatterEvaluator().mustExcludeAntPathMatchers("/swagger-ui", "/swagger-ui/**", "/v3", "/v3/**");
    }
}
