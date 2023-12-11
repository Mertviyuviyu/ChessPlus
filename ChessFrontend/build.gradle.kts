plugins {
    id("application")
}

application {
    mainClass = "org.checkmatecoders.frontend.Main"
}

dependencies {
    implementation(project(":ChessEngine"))
}