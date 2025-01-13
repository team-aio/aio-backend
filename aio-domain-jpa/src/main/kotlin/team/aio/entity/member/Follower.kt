package team.aio.entity.member

import jakarta.persistence.*
import team.aio.entity.BaseEntity

@Entity
class Follower(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,
    @ManyToOne
    @JoinColumn(name = "following_id")
    val follower: Member
) : BaseEntity() {

}