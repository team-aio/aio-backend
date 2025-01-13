package team.toasting.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.toasting.entity.member.Member

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
}