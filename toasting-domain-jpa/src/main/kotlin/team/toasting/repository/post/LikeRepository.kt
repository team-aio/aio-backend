package team.toasting.repository.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.post.Like

@Repository
interface LikeRepository : JpaRepository<Like, Long> {
}