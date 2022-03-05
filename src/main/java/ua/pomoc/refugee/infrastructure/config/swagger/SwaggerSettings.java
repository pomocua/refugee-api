package ua.pomoc.refugee.infrastructure.config.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerSettings {

    @NotBlank
    private String host;

    @NotBlank
    private String scheme;

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}