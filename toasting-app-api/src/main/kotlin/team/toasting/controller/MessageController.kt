package team.toasting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.toasting.api.ApiResponse
import team.toasting.controller.dto.GetMessageCountResponse

@RestController
@RequestMapping("/v1/messages")
class MessageController {

    @GetMapping("/count")
    fun getMessageCount(): ApiResponse<GetMessageCountResponse> {
        return ApiResponse.onSuccess(GetMessageCountResponse.mock())
    }
}