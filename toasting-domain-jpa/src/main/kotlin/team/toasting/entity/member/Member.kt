package team.toasting.entity.member

import jakarta.persistence.*
import team.toasting.entity.BaseEntity

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val profilePicture: String? = null,
    val velogId: Long? = null,
    val tistoryId: Long? = null,
    val nickname: String,
    val email: String,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "social_login_id")
    val socialLogin: SocialLogin,
) : BaseEntity() {
    companion object {
        fun defaultMember(
            nickname: String,
            email: String,
            socialLogin: SocialLogin,
        ) = Member(
            nickname = nickname,
            email = email,
            socialLogin = socialLogin,
        )
    }

    fun updateWith(
        nickname: String,
        email: String,
    ): Member =
        Member(
            id = id,
            profilePicture = profilePicture,
            velogId = velogId,
            tistoryId = tistoryId,
            nickname = nickname,
            email = email,
            socialLogin = socialLogin,
        )
}
