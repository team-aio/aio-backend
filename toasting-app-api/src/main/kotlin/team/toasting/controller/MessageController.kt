package team.toasting.controller

import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import team.toasting.api.ApiResponse
import team.toasting.api.PageResponse
import team.toasting.controller.dto.request.*
import team.toasting.controller.dto.response.*

@RestController
@RequestMapping("/v1/messages")
class MessageController {

    @GetMapping("/count")
    fun getMessageCount(): ApiResponse<GetMessageCountResponseDTO> {
        return ApiResponse.onSuccess(GetMessageCountResponseDTO.mock())
    }

    @PostMapping
    fun sendMessage(
        @RequestBody @Valid request: SendMessageRequestDTO
    ): ApiResponse<SendMessageResponseDTO> {
        return ApiResponse.onSuccess(SendMessageResponseDTO.mock())
    }

    @GetMapping
    fun getMessages(
        @PageableDefault(page = 0, size = 10) pageable: Pageable
    ): ApiResponse<PageResponse<GetMessagesResponseDTO>> {
        val content = List(10) { GetMessagesResponseDTO.mock() }
        return ApiResponse.onSuccess(PageResponse.of(content, 10, 100))
    }

    @PutMapping("/partner/{partnerId}")
    fun readAllMessage(
        @PathVariable partnerId: Long
    ): ApiResponse<Void> {
        return ApiResponse.onSuccess(null)
    }
}