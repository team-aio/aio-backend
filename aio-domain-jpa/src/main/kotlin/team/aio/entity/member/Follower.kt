package team.aio.entity.member

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.aio.entity.BaseEntity

@Entity
@DynamicInsert
@DynamicUpdate
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