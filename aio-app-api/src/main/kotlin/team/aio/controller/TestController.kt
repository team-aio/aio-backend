package team.aio.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import team.aio.api.ApiResponse
import team.aio.api.code.status.ErrorStatus
import team.aio.api.exception.handler.ExampleHandler
import team.aio.controller.dto.TestResponseDTO

@RestController
class TestController {
    @GetMapping("/test")
    fun test(): ApiResponse<TestResponseDTO.Test> {
        val test = TestResponseDTO.Test("test")
        return ApiResponse.onSuccess(test)
    }

    @GetMapping("/test/exception")
    fun test2(@RequestParam("flag") flag: Int): ApiResponse<TestResponseDTO.Test> {
        if (flag == -1) {
            throw ExampleHandler(ErrorStatus.BAD_REQUEST)
        }
        if (flag == 0) {
            throw IllegalArgumentException(ErrorStatus.INTERNAL_SERVER_ERROR.toString())
        }
        return ApiResponse.onSuccess(TestResponseDTO.Test(flag.toString()))
    }
}