package team.toasting.entity.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
) : BaseEntity() {
    companion object {
        fun defaultMember(
            nickname: String,
            email: String,
        ) = Member(
            nickname = nickname,
            email = email,
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
        )
}
