package team.toasting

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class JWTUtilTest :
    BehaviorSpec({
        val jwtUtil = JWTUtil(secret = "asdfsdfsdfdsf")
        Given("JWT 생성 테스트에서") {
            val username = "howudong"
            val role = "ROLE_USER"
            When("JWT를 생성했을 때") {
                val token = jwtUtil.createJwt(username, role, 60 * 60 * 12)
                Then("담긴 값들이 모두 추출되어야한다.") {
                    jwtUtil.getRole(token) shouldBe role
                    jwtUtil.getUsername(token) shouldBe username
                }
                Then("잘못된 토큰으로 추출하려고 하면 null을 반환한다.") {
                    val result = jwtUtil.getRole("invalidToken.dsfd.ss")
                    result shouldBe null
                }
            }
        }
    })
