package team.aio.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.aio.entity.member.Follower

@Repository
interface FollowerRepository : JpaRepository<Follower, Long> {
}