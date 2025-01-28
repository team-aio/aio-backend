package team.toasting.controller.dto

import java.time.LocalDateTime

class SearchPostsResponse(
    val id: Long,
    val title: String,
    val content: String,
    val likeCount: Int,
    val postedAt: LocalDateTime ?,
    val sourceType: String,
    val memberInfo: MemberInfo
) {
    companion object {
        fun mock() = SearchPostsResponse(
            id = 1L,
            title = "mock title",
            content = "mock short content mock short content mock short content mock short content mock short content " +
                    "mock short content mock short content mock short content mock short content mock short content " +
                    "mock short content mock short content mock short content mock short content mock short content " +
                    "mock short content mock short content mock short content mock short content mock short content mock short content",
            likeCount = 100,
            postedAt = LocalDateTime.now(),
            sourceType = "velog",
            memberInfo = MemberInfo.mock()
        )
    }
}