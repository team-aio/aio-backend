package team.aio.api.code

interface BaseErrorCode {
    fun getReason(): ErrorReasonDTO
}