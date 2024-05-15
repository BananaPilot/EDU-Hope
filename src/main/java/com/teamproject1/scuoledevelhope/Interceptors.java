package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.classes.register.RegisterInterceptor;
import com.teamproject1.scuoledevelhope.classes.report.ReportInterceptor;
import com.teamproject1.scuoledevelhope.classes.vote.VoteInterceptor;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Component
public class Interceptors implements WebMvcConfigurer {

    private final ReportInterceptor reportInterceptor;
    private final RegisterInterceptor registerInterceptor;
    private final VoteInterceptor voteInterceptor;

    public Interceptors(ReportInterceptor reportInterceptor, RegisterInterceptor registerInterceptor, VoteInterceptor voteInterceptor) {
        this.reportInterceptor = reportInterceptor;
        this.registerInterceptor = registerInterceptor;
        this.voteInterceptor = voteInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(reportInterceptor.setPaths(List.of("/report")));
        registry.addInterceptor(voteInterceptor.setPaths(List.of("/vote/**")));
        registry.addInterceptor(registerInterceptor.setPaths(List.of("/register/all-student/**", "/register/all-vote/**")));
    }

}
