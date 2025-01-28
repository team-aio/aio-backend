package team.toasting.security.handler

import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import team.toasting.JWTUtil
import team.toasting.oauth2.dto.OAuth2UserDTO

@Component
class CustomSuccessHandler(
    private val jwtUtil: JWTUtil,
) : SimpleUrlAuthenticationSuccessHandler() {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication?,
    ) {
        if (authentication == null) return

        val username = authentication.parseUsername()
        val role = authentication.parseRole()

        val token = jwtUtil.createJwt(username, role, 60 * 60 * 60)
        response.addCookie(createCookie("Authorization", token))
        response.sendRedirect("http://localhost:3000/")
    }

    private fun Authentication.parseUsername() = (this.principal as OAuth2UserDTO).name

    private fun Authentication.parseRole(): String =
        this.authorities
            .iterator()
            .next()
            .authority

    private fun createCookie(
        key: String,
        value: String,
    ): Cookie {
        val cookie = Cookie(key, value)
        cookie.maxAge = 60 * 60 * 60
        cookie.path = "/"
        cookie.isHttpOnly = true

        return cookie
    }
}
