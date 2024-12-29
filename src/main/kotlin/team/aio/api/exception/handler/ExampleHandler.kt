package team.aio.api.exception.handler

import team.aio.api.code.BaseErrorCode
import team.aio.api.exception.GeneralException

class ExampleHandler(errorCode: BaseErrorCode) : GeneralException(errorCode) {

}