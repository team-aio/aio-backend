plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "toasting"

include("toasting-app-api")
include("toasting-display-swagger")
include("toasting-core-api-response")
include("toasting-domain-jpa")
include("toasting-jwt")
