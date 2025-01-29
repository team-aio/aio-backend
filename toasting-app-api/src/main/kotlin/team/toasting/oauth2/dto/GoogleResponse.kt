package team.toasting.oauth2.dto

class GoogleResponse(
    private val attribute: Map<String, Any>,
) : OAuth2Response {
    override val provider: String
        get() = "google"
    override val providerId: String
        get() = attribute["sub"].toString()
    override val email: String
        get() = attribute["email"].toString()
    override val name: String
        get() = attribute["name"].toString()
}
