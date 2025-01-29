package team.toasting.controller.dto.response

class ExistsFollowingResponseDTO(
    val isExists: Boolean
) {
    companion object {
        fun mock() = ExistsFollowingResponseDTO(
            isExists = false
        )
    }
}