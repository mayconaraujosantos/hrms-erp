package com.mkdata.hrms.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info =
                @Info(
                        contact =
                                @Contact(
                                        name = "Contact",
                                        email = "maycon.araujo.santos@gmail.com",
                                        url = "https://hrms-erp-production.up.railway.app"),
                        description = "OpenApi documentation for Spring Security",
                        title = "OpenApi specification",
                        version = "1.0",
                        license = @License(name = "Licence name", url = "https://some-url.com"),
                        termsOfService = "Terms of service"),
        servers = {
            @Server(description = "Local ENV", url = "http://localhost:8080"),
            @Server(description = "PROD ENV", url = "https://hrms-erp-production.up.railway.app")
        },
        security = {@SecurityRequirement(name = "bearerAuth")})
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER)
@Configuration
public class OpenApiConfig {}
