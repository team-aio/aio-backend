package team.toasting.entity.member

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import team.toasting.entity.BaseEntity

@Entity
class SocialLogin(
    val socialCode: String,
    val externalId: String,
    val accessToken: String,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val member: Member,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity()
