package team.toasting.controller

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.toasting.api.ApiResponse
import team.toasting.api.PageResponse
import team.toasting.controller.dto.response.*

@RestController
@RequestMapping("/v1/posts")
internal class PostController {

    @GetMapping("/search")
    fun searchPosts(
        @PageableDefault(page = 0, size = 10, sort = arrayOf("postedAt"), direction = Sort.Direction.DESC) pageable: Pageable
    ): ApiResponse<PageResponse<SearchPostsResponseDTO>> {
        val content = List(10) { SearchPostsResponseDTO.mock() }
        return ApiResponse.onSuccess(PageResponse.of(content, 10, 100))
    }
}