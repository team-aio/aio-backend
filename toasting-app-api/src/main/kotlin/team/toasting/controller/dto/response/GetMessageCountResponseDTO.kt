package team.toasting.controller.dto.response

class GetMessageCountResponseDTO(
    val count: Int
){
    companion object {
        fun mock() = GetMessageCountResponseDTO(
            count = 10
        )
    }
}