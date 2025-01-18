package team.toasting.entity.member

import jakarta.persistence.*
import team.toasting.entity.BaseEntity

@Entity
class Following(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,
    @ManyToOne
    @JoinColumn(name = "following_id")
    val following: Member
) : BaseEntity() {

}