package team.toasting.controller.dto.response

import java.time.LocalDateTime
import kotlin.random.Random

class GetMessagesResponse(
    val messages: List<Message>
) {
    class Message(
        val memberId: Long,
        val profilePicture: String ?,
        val lastMessageContent: String,
        val lastMessageCreatedAt: LocalDateTime,
        val notReadMessageCount: Int
    ) {
        companion object {
            fun mock() = Message(
                Random.nextLong(1, 10),
                "st",
                "last message content",
                LocalDateTime.now(),
                Random.nextInt(1, 10)
            )
        }
    }

    companion object {
        fun mock(): GetMessagesResponse {
            val messages =  List(10) { Message.mock() }
            return GetMessagesResponse(messages)
        }
    }

}