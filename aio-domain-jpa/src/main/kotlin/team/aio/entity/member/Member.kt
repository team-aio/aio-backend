package team.aio.entity.member

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
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