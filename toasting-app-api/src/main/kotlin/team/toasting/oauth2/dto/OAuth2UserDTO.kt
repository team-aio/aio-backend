package team.toasting.oauth2.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

data class OAuth2UserDTO(
    private val role: String,
    private val memberId: Long,
    private val email: String,
) : OAuth2User {
    override fun getName(): String = memberId.toString()

    override fun getAttributes(): Map<String, Any> = emptyMap<String, Any>()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val collection: MutableCollection<GrantedAuthority> = mutableListOf()
        collection.add(
            GrantedAuthority { role },
        )
        return collection
    }

    fun getEmail(): String = email
}
