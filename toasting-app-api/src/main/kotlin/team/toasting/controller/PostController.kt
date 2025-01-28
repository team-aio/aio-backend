package team.toasting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.toasting.api.ApiResponse
import team.toasting.controller.dto.SearchPostsResponse

@RestController
@RequestMapping("/v1/posts")
internal class PostController {

    @GetMapping("/search")
    fun searchPosts(): ApiResponse<SearchPostsResponse> {
        return ApiResponse.onSuccess(SearchPostsResponse.mock())
    }
}