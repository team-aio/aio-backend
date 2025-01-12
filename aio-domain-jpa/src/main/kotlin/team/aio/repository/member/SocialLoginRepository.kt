package team.aio.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.aio.entity.member.SocialLogin

@Repository
interface SocialLoginRepository : JpaRepository<SocialLogin, Long> {
}