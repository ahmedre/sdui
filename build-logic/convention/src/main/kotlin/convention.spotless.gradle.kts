import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.kotlin.dsl.apply

subprojects {
    afterEvaluate {
        apply(plugin = "com.diffplug.spotless")
        extensions.configure<SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                targetExclude("${layout.buildDirectory}/**/*.kt", "**/copyright.kt", "**/build/**")
                licenseHeaderFile(rootProject.file("$rootDir/spotless/copyright.kt"))
                trimTrailingWhitespace()
                endWithNewline()
            }
            format("kts") {
                target("**/*.kts")
                targetExclude("${layout.buildDirectory}/**/*.kts", "**/copyright.kts", "**/build/**")
                // Look for the first line that doesn't have a block comment (assumed to be the license)
                licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
            }
            format("xml") {
                target("**/*.xml")
                targetExclude("**/build/**/*.xml", "**/copyright.xml", "**/build/**")
                // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
                licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
            }
        }
    }
}