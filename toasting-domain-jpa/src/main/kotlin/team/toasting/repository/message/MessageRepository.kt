package team.toasting.repository.message

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.message.Message

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
}