package team.toasting.entity.post

import jakarta.persistence.*
import team.toasting.entity.BaseEntity

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val post: Post,
    val category: String
) : BaseEntity() {

}