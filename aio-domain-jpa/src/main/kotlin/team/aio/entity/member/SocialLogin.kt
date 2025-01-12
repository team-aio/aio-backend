package team.aio.entity.member

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.aio.entity.BaseEntity

@Entity
@DynamicInsert
@DynamicUpdate
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