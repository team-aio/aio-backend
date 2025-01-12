package team.aio.entity.message

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.aio.entity.BaseEntity

@Entity
@DynamicInsert
@DynamicUpdate
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val content: String,
    val senderId: Long,
    val receiverId: Long
) : BaseEntity() {

}