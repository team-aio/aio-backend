package team.aio.api.exception

import team.aio.api.code.BaseErrorCode
import team.aio.api.code.ErrorReasonDTO

open class GeneralException(
    private val errorCode: BaseErrorCode
) : RuntimeException() {
    fun getErrorReason(): ErrorReasonDTO = errorCode.getReason()
}