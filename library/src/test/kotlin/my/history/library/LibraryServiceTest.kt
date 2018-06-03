package my.history.library

import my.history.library.model.Library
import my.history.library.service.LibraryService
import org.assertj.core.api.BDDAssertions.then
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono
import java.util.ArrayList
import reactor.test.StepVerifier
import java.util.function.Supplier


@RunWith(SpringRunner::class)
@SpringBootTest
class LibraryServiceTest{

    @Autowired
    lateinit var LibraryService:LibraryService

    @Test
    fun getAll() {
        val item : Flux<Library> =  LibraryService.getLibraryAll()

        then(item).isNotNull
        println("tttttesss")
        item.map { a -> assertThat(a.id, `is`("2")) }
    }

}
