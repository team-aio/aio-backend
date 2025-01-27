package team.toasting.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.member.SocialLogin

@Repository
interface SocialLoginRepository : JpaRepository<SocialLogin, Long> {
    fun findByExternalIdAndAccessToken(
        externalCode: String,
        accessToken: String,
    ): SocialLogin?
}
