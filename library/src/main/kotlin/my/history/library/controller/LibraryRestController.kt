package my.history.library.controller

import my.history.library.model.Library
import my.history.library.model.LibraryDto
import my.history.library.model.LibraryReq
import my.history.library.service.LibraryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import javax.validation.Valid

@RestController
class LibraryRestController(private val libraryService: LibraryService) {

    // 検索
    @GetMapping("/libraryAlljsonstream", produces = ["application/stream+json"])
    fun getStreamLibraryAll() : Flux<Library> = libraryService.getLibraryAll()

    @GetMapping("/libraryAlljson")
    fun getLibraryAll() = libraryService.getLibraryAll()

    @GetMapping("/libraryAlljson/{title}")
    fun getLibraryAllConditional(@PathVariable("title") title: String)
            = libraryService.getLibraryTitle(title).map { LibraryDto.toDto(it) }

    @GetMapping("/library/getid/{id}")
    fun getLibraryId(@PathVariable("id") id: String) = libraryService.getLibraryId(id).map { LibraryDto.toDto(it) }

    // 更新
    @PutMapping("/library/update/{id}")
    fun updateEmployee(@PathVariable id: String,
                       @RequestBody libraryReq: LibraryReq)
            = libraryService.updateLibrary(id, libraryReq).map { _ -> ResponseEntity.ok().build<String>()}

    // 作成
    @PostMapping("/library/create")
    fun createEmployee(@Valid @RequestBody libraryDto: LibraryDto)
            = libraryService.createLibrary(libraryDto)
            .map { newLibrary -> ResponseEntity.status(HttpStatus.CREATED).body(newLibrary) }

    // 削除
    @DeleteMapping("/library/delete/{id}")
    fun deleteEmployee(@PathVariable id: String): ResponseEntity<String> {
        libraryService.deleteLibrary(id).block()
        return ResponseEntity.status(HttpStatus.OK).build<String>()
    }

}
