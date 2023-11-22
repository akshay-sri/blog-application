package com.blog.project.config;

public class AppConstants {
    public static final String PAGE_NUMBER = "0";
    public static final String PAGE_SIZE = "5";
    public static final String SORT_BY = "postId";
    public static final String SORT_DIR = "asc";
    public static final String ADMIN_USER = "R01";
    public static final String NORMAL_USER = "R02";
    public static final String[] PUBLIC_URLS = {
            "/auth/**",
            "/v3/api-docs",
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"
    };
}
