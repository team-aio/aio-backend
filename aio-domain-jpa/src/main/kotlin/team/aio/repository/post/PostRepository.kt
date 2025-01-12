package team.aio.repository.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.aio.entity.post.Post

@Repository
interface PostRepository : JpaRepository<Post, Long> {
}