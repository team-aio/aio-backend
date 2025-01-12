package team.aio.repository.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.aio.entity.post.Like

@Repository
interface LikeRepository : JpaRepository<Like, Long> {
}