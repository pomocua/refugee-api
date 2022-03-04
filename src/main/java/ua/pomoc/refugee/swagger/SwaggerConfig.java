package ua.pomoc.refugee.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Validated
@Configuration
@EnableSwagger2
class SwaggerConfig {

    private final SwaggerSettings swaggerSettings;

    @Bean
    public Docket springFoxConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ua.pomoc.refugee"))
                .paths(PathSelectors.any())
                .build()
                .protocols(Set.of(swaggerSettings.getScheme()))
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .apiInfo(metadata());

    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(swaggerSettings.getTitle())
                .description(swaggerSettings.getDescription())
                .build();
    }
}