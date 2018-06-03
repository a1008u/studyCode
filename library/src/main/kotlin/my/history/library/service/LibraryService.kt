package my.history.library.service

import my.history.library.repository.LibraryRepository
import my.history.library.model.Library
import my.history.library.model.LibraryDto
import my.history.library.model.LibraryReq
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LibraryService(private val libraryRepository: LibraryRepository) {

    // 検索
    fun getLibraryAll(): Flux<Library> = libraryRepository.findAll()

    fun getLibraryTitle(title:String) = libraryRepository
            .findAll()
            .filter{title.matches(it.title.toRegex())}

    fun getLibraryId(id:String) = libraryRepository.findById(id)

    // 作成
    fun createLibrary(libraryDto: LibraryDto):Mono<Library> = libraryRepository.save(LibraryDto.fromDto(libraryDto))

    // 更新
    fun updateLibrary(id: String, libraryReq: LibraryReq): Mono<Library> {
        return libraryRepository.findById(id)
                .flatMap {
                    it.title = libraryReq.title ?: it.title
                    it.explain = libraryReq.explain ?: it.explain
                    libraryRepository.save(it)
                }
    }

    // 削除
    fun deleteLibrary(id: String): Mono<Void> = libraryRepository.deleteById(id)


}
