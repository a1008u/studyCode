package ch08.ex1_6_2_RemovingDuplicationThroughLambdas1

data class SiteVisit(val path: String
                     , val duration: Double
                     , val os: OS)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(SiteVisit("/", 34.0, OS.WINDOWS)
                 , SiteVisit("/", 22.0, OS.MAC)
                 , SiteVisit("/login", 12.0, OS.WINDOWS)
                 , SiteVisit("/signup", 8.0, OS.IOS)
                 , SiteVisit("/", 16.3, OS.ANDROID)
                )

// 拡張関数として書き直す
fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()

fun main(args: Array<String>) {
    println(log.averageDurationFor(OS.WINDOWS)) // 23.0
    println(log.averageDurationFor(OS.MAC)) // 22.0
}
