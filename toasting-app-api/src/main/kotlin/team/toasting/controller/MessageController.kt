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
import team.toasting.controller.dto.request.*
import team.toasting.controller.dto.response.*

@RestController
@RequestMapping("/v1/messages")
class MessageController {

    @GetMapping("/count")
    fun getMessageCount(): ApiResponse<GetMessageCountResponse> {
        return ApiResponse.onSuccess(GetMessageCountResponse.mock())
    }

    @PostMapping
    fun sendMessage(
        @RequestBody @Valid request: SendMessageRequest
    ): ApiResponse<SendMessageResponse> {
        return ApiResponse.onSuccess(SendMessageResponse.mock())
    }

    @GetMapping
    fun getMessages(
        @PageableDefault(page = 0, size = 10) pageable: Pageable
    ): ApiResponse<GetMessagesResponse> {
        return ApiResponse.onSuccess(GetMessagesResponse.mock())
    }

    @PutMapping("/partner/{partnerId}")
    fun readAllMessage(
        @PathVariable partnerId: Long
    ): ApiResponse<Void> {
        return ApiResponse.onSuccess(null)
    }
}