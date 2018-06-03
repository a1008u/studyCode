package my.history.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}

@Bean
internal fun hiddenHttpMethodFilter(): HiddenHttpMethodFilter = HiddenHttpMethodFilter()
