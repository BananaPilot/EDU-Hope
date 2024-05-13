package com.teamproject1.scuoledevelhope.types;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public abstract class Interceptor implements HandlerInterceptor {

    private List<String> paths;

    private final PathMatcher pathMatcher = new AntPathMatcher();


    @Transactional
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!includePath(request)) return true;
        if (includePath(request) && handle(request)) return true;
        response.sendError(403, "Forbidden");
        return false;
    }

    public abstract boolean handle(HttpServletRequest request);

    private boolean includePath(HttpServletRequest request) {
        boolean bool = false;

        for (String path : this.paths) {
            if (pathMatcher.match(path, request.getRequestURI())) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public Interceptor setPaths(List<String> paths) {
        this.paths = paths;
        return this;
    }
}
