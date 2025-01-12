package team.aio.repository.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.aio.entity.post.Likes

@Repository
interface LikesRepository : JpaRepository<Likes, Long> {
}