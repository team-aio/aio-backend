package team.aio.entity.message

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import team.aio.entity.BaseEntity

@Entity
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val content: String,
    val senderId: Long,
    val receiverId: Long
) : BaseEntity() {

}