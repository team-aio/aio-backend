package team.toasting.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.member.Follower

@Repository
interface FollowerRepository : JpaRepository<Follower, Long> {
}