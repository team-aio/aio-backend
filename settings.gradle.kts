plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "aio"
include("aio-app-api")
include("aio-display-swagger")
include("aio-core-security")
include("aio-core-api-response")
include("aio-domain-jpa")
