package team.aio.api.code

import org.springframework.http.HttpStatus

class ReasonDTO(
    val httpStatus: HttpStatus,
    val code: String,
    val message: String
)