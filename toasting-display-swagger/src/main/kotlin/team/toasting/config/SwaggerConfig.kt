package team.toasting.config

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

    @Bean
    fun followingGroupedOpenApi(): GroupedOpenApi =
        GroupedOpenApi
            .builder()
            .group("following")
            .pathsToMatch("/v1/following/**")
            .addOpenApiCustomizer {
                it.info = Info()
                    .title("Following Api")
                    .version("0.0.1")
                    .description("팔로잉 API")
            }
            .build()

    @Bean
    fun postGroupedOpenApi(): GroupedOpenApi =
        GroupedOpenApi
            .builder()
            .group("post")
            .pathsToMatch("/v1/posts/**")
            .addOpenApiCustomizer {
                it.info = Info()
                    .title("Post Api")
                    .version("0.0.1")
                    .description("게시글 API")
            }
            .build()
    @Bean
    fun messageGroupedOpenApi(): GroupedOpenApi =
        GroupedOpenApi
            .builder()
            .group("message")
            .pathsToMatch("/v1/messages/**")
            .addOpenApiCustomizer {
                it.info = Info()
                    .title("Messages Api")
                    .version("0.0.1")
                    .description("메세지 API")
            }
            .build()
}