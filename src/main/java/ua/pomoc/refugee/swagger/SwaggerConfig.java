package ua.pomoc.refugee.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Validated
@Configuration
class SwaggerConfig {

    private final SwaggerSettings swaggerSettings;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info().title(swaggerSettings.getTitle()).description(swaggerSettings.getDescription())
                );
    }

    private GroupedOpenApi metadata() {
        return GroupedOpenApi.builder()
                .group(swaggerSettings.getTitle())
                .pathsToMatch("/**")
                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(RestController.class))
                .build();
    }
}