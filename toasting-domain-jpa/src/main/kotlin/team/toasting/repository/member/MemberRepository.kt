package team.toasting.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.member.Member
import team.toasting.entity.member.SocialLogin

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findBySocialLogin(socialLogin: SocialLogin): Member?
}
