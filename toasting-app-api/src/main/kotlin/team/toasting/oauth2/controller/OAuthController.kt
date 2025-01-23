package team.toasting.oauth2.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component
import team.toasting.oauth2.dto.GoogleResponse
import team.toasting.oauth2.dto.OAuth2Response
import team.toasting.oauth2.dto.OAuth2UserDTO

@Component
class OAuthController : DefaultOAuth2UserService() {
    private val log = KotlinLogging.logger {}

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User? {
        if (userRequest == null) {
            log.error { "[OAuthController] userRequest is null]" }
            return null
        }
        val oAuth2Response =
            createOAuth2Response(userRequest)
                ?: run {
                    log.error { "[OAuthController] oAuth2Response is null" }
                    return null
                }

        val oAuth2UserDTO =
            OAuth2UserDTO(
                role = "ROLE_USER",
                name = oAuth2Response.name,
                email = oAuth2Response.email,
            )
        log.info { oAuth2UserDTO }
        return oAuth2UserDTO
    }

    private fun createOAuth2Response(userRequest: OAuth2UserRequest): OAuth2Response? {
        val registrationId = userRequest.clientRegistration.registrationId

        return when (registrationId) {
            "google" -> {
                GoogleResponse(super.loadUser(userRequest).attributes)
            }

            else -> {
                return null
            }
        }
    }
}
