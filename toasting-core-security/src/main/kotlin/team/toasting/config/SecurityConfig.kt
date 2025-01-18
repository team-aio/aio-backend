package team.toasting.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {
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
            .oauth2Login {}
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http.authorizeHttpRequests {
            it
                .requestMatchers("/**")
                .permitAll()
                .anyRequest()
                .authenticated()
        }

        return http.build()
    }
}
