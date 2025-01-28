import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JWTUtil(
    @Value("\${spring.jwt.secret}") val secret: String,
) {
    private val log = KotlinLogging.logger {}

    fun createJwt(
        username: String,
        role: String,
        expiredMs: Long,
    ): String =
        JWT
            .create()
            .withClaim("username", username)
            .withClaim("role", role)
            .withExpiresAt(Date(System.currentTimeMillis() + expiredMs))
            .withIssuedAt(Date(System.currentTimeMillis()))
            .sign(Algorithm.HMAC256(secret)) // 대칭키 사용

    fun getRole(token: String): String? =
        runCatching {
            JWT
                .require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getClaim("role")
                .asString()
        }.onFailure {
            log.warn { "Token verification failed: ${it.message}" }
        }.getOrNull()

    fun getUsername(token: String): String? =
        runCatching {
            JWT
                .require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getClaim("username")
                .asString()
        }.onFailure {
            log.warn { "Token verification failed: ${it.message}" }
        }.getOrNull()
}
