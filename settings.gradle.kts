plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "aio"
include("aio-app-api")
include("application")
include("module")
include("aio-core-web-swagger")
include("aio-core-swagger")
include("aio-display-swagger")
