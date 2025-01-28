package team.toasting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.toasting.api.ApiResponse
import team.toasting.controller.dto.GetMessageCountResponse
import team.toasting.controller.dto.SendMessageResponse

@RestController
@RequestMapping("/v1/messages")
class MessageController {

    @GetMapping("/count")
    fun getMessageCount(): ApiResponse<GetMessageCountResponse> {
        return ApiResponse.onSuccess(GetMessageCountResponse.mock())
    }

    @PostMapping
    fun sendMessage(): ApiResponse<SendMessageResponse> {
        return ApiResponse.onSuccess(SendMessageResponse.mock())
    }
}