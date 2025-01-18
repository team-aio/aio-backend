package team.toasting.entity.post

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import team.toasting.entity.BaseEntity
import java.time.LocalDateTime

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val sourceType: String,
    val postedAt: LocalDateTime? = null,
    val content: String? = null,
    val title: String,
    val likeCount: Int = 0,
    val memberId: Long
) : BaseEntity() {

}