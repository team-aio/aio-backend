package team.toasting.entity.member

import jakarta.persistence.*
import team.toasting.entity.BaseEntity

@Entity
class SocialLogin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val socialCode: String,
    val externalId: String? = null,
    val accessToken: String? = null,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val member: Member
) : BaseEntity() {
}