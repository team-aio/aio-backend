package team.aio.entity.member

import jakarta.persistence.*
import team.aio.entity.BaseEntity

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val profilePicture: String? = null,
    val velogId: Long? = null,
    val tistoryId: Long? = null,
    val nickname: String
) : BaseEntity() {

}