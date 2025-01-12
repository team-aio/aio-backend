package team.aio.entity.post

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.aio.entity.BaseEntity
import java.time.LocalDateTime

@Entity
@DynamicInsert
@DynamicUpdate
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