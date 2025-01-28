package team.toasting.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import team.toasting.oauth2.controller.OAuthController
import team.toasting.security.handler.CustomSuccessHandler

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val oAuthController: OAuthController,
    private val customSuccessHandler: CustomSuccessHandler,
) {
    @Bean
    fun corsConfigSource(): CorsConfigurationSource {
        val corsConfig = CorsConfiguration()
        corsConfig.apply {
            allowedHeaders = listOf("*")
            allowedOrigins = listOf("http://localhost:3000")
            exposedHeaders = listOf("*")
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
            allowCredentials = true
            maxAge = 3600
        }

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)
        return source
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic { it.disable() }
            .csrf { it.disable() }
            .cors { it.configurationSource(corsConfigSource()) }
            .formLogin { it.disable() } // cors 설정 활성화
            .oauth2Login { oAuth2 ->
                oAuth2
                    .userInfoEndpoint { it.userService(oAuthController) }
                    .successHandler(customSuccessHandler)
            }.sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http.authorizeHttpRequests {
            it
                .requestMatchers(
                    "/",
                    "/h2-console/**",
                    "/favicon.ico",
                    "/error",
                    "/swagger-ui/**",
                    "/swagger-resources/**",
                    "/v3/api-docs/**",
                ).permitAll()
                .anyRequest()
                .authenticated()
        }
        return http.build()
    }
}
