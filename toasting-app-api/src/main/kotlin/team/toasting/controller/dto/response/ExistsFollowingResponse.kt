package team.toasting.controller.dto.response

class ExistsFollowingResponse(
    val isExists: Boolean
) {
    companion object {
        fun mock() = ExistsFollowingResponse(
            isExists = false
        )
    }
}