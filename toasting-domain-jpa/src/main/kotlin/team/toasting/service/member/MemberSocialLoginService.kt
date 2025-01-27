package team.toasting.service.member

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import team.toasting.entity.member.Member
import team.toasting.entity.member.SocialLogin
import team.toasting.repository.member.MemberRepository
import team.toasting.repository.member.SocialLoginRepository

@Service
class MemberSocialLoginService(
    private val memberRepository: MemberRepository,
    private val socialLoginRepository: SocialLoginRepository,
) {
    private val log = KotlinLogging.logger {}

    fun upsertBy(
        externalId: String,
        accessToken: String,
        nickname: String,
        email: String,
    ): Long? {
        val socialLogin = socialLoginRepository.findByExternalIdAndAccessToken(externalId, accessToken)

        if (socialLogin == null) {
            return createNewMember(externalId, accessToken, nickname, email).id!!
        }

        return updateMember(socialLogin, nickname, email)?.id!!
    }

    private fun updateMember(
        socialLogin: SocialLogin,
        nickname: String,
        email: String,
    ): Member? {
        val member = memberRepository.findBySocialLogin(socialLogin)
        return member?.updateWith(nickname, email)
    }

    private fun createNewMember(
        externalId: String,
        accessToken: String,
        nickname: String,
        email: String,
    ): Member {
        val socialLogin = SocialLogin(id = null, "0", externalId, accessToken)
        return memberRepository.save(
            Member.defaultMember(
                nickname,
                email,
                socialLogin,
            ),
        )
    }
}
