package com.blog.project.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Blog Application",
                        email = "kingakshay595@gmail.com",
                        url = "https://www.youtube.com/playlist?list=PL0zysOflRCen-GihOcm1hZfYAlwr63K_M"
                ),
                description = "Swagger documentation for Blog Application",
                title = "Swagger specification - Akshay",
                version = "1.0",
                license = @License(
                        name = "License",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = { //provide list of url for diff environment
                @Server(
                        description = "Local Env",
                        url = "http://localhost:9090"
                ),
                @Server(
                        description = "Prod Env",
                        url = "https://some-url.com"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "BearerAuth"
                )
        }
)
@SecurityScheme(
        name = "BearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
