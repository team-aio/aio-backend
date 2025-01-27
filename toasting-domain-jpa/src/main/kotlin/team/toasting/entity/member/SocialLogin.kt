package team.toasting.entity.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import team.toasting.entity.BaseEntity

@Entity
class SocialLogin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val socialCode: String,
    val externalId: String? = null,
    val accessToken: String? = null,
) : BaseEntity()
