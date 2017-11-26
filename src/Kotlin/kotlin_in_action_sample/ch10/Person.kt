package Kotlin.kotlin_in_action_sample.ch10

import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName


data class Person2(
        @JsonName("alias") val firstName: String,
        @JsonExclude val age: Int? = null
)