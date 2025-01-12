package team.aio.entity.post

import jakarta.persistence.*
import team.aio.entity.BaseEntity

@Table(name = "likes")
@Entity
class Like(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val post: Post,
    val memberId: Long
) : BaseEntity() {

}