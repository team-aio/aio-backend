package team.toasting.controller.dto.response

import java.time.LocalDateTime

class SendMessageResponseDTO (
    val id: Long,
    val postId: Long ?,
    val receiverId: Long,
    val content: String,
    val createdAt: LocalDateTime
) {
    companion object {
        fun mock() = SendMessageResponseDTO(
            id = 1L,
            postId = 2L,
            receiverId = 3L,
            content = "Hello World",
            createdAt = LocalDateTime.now()
        )
    }
}