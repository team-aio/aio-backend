package team.toasting.security.filter

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import team.toasting.JWTUtil
import team.toasting.oauth2.dto.OAuth2UserDTO

class JwtFilter(
    private val jwtUtil: JWTUtil,
) : OncePerRequestFilter() {
    private val log = KotlinLogging.logger {}

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val token =
            request.cookies
                .find { it.name.equals("Authorization") }
                ?.value

        if (token == null) {
            log.info { "token is null" }
            filterChain.doFilter(request, response)
            return
        }

        if (jwtUtil.isExpired(token)) {
            log.info { "token is expired" }
            filterChain.doFilter(request, response)
            return
        }
        val role = jwtUtil.getRole(token)
        val memberId = jwtUtil.getMemberId(token)?.toLong()

        if (role == null || memberId == null) {
            log.info { "role or member Id is null" }
            filterChain.doFilter(request, response)
            return
        }
        val oAuth2UserDTO = OAuth2UserDTO(role, memberId)
        val authToken = UsernamePasswordAuthenticationToken(oAuth2UserDTO, null, oAuth2UserDTO.authorities)
        SecurityContextHolder.getContext().authentication = authToken
        filterChain.doFilter(request, response)
    }
}
