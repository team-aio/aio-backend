package team.aio.api.code

import org.springframework.http.HttpStatus

class ErrorReasonDTO(
    val httpStatus: HttpStatus,
    val code: String,
    val message: String
)