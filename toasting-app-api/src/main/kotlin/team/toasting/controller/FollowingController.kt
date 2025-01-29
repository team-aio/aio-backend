package team.toasting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.toasting.api.ApiResponse
import team.toasting.controller.dto.response.*

@RestController
@RequestMapping("/v1/following")
class FollowingController {

    @GetMapping("/{followingId}/exists")
    fun existsFollowing(@PathVariable followingId: Long): ApiResponse<ExistsFollowingResponse> {
        return ApiResponse.onSuccess(ExistsFollowingResponse.mock())
    }
}