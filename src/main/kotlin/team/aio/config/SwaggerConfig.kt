package team.aio.config

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun testGroupedOpenApi(): GroupedOpenApi =
        GroupedOpenApi
            .builder()
            .group("test")
            .pathsToMatch("/test/**")
            .addOpenApiCustomizer {
                it.info = Info()
                    .title("Test Api")
                    .version("0.0.1")
                    .description("테스트용 API")
            }.build()
}