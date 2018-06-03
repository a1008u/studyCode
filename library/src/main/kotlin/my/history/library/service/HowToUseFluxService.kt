package my.history.library.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.io.FileWriter
import org.springframework.util.FileCopyUtils
import java.nio.file.Files.createDirectory
import org.springframework.util.FileSystemUtils
import java.io.IOException
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import java.nio.file.Files.deleteIfExists
import org.springframework.http.codec.multipart.FilePart
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


@Service
class HowToUseFluxService(private val resourceLoader: ResourceLoader){
    /**
     * サンプル(0..N個のアイテムを保持するコンテナ)
     * subscribe()をするまでは、文字列を保持しているコンテナ
     * 静的ヘルパーメソッド：just()以外にfromArrayやfromIterableやfromStreamもある
     *
     */
    fun createFlux()
            = Flux
            .just("test","test2","test3")
            .subscribe{item -> println(item)}

    fun sample()
            = Flux.just("alpha", "bravo", "charlie")
            .map(String::toUpperCase)
            .flatMap{s -> Flux.fromArray(s.split("").toTypedArray())}
            .groupBy(String::toString)
            .flatMap{group -> Mono.just(group.key()!!).and(group.count())}
            .subscribe{item -> println(item.toString())}
//            .map {keyAndCount -> keyAndCount.toString() + " => " + keyAndCount.toString()}
//            .subscribe{item -> println(item)}

    private val UPLOAD_ROOT = "upload-dir"
    fun findOneImage(filename: String): Mono<Resource> {
        return Mono.fromSupplier {
            resourceLoader.getResource(
                    "file:$UPLOAD_ROOT/$filename")
        }
    }

    fun createImage(files: Flux<FilePart>): Mono<Void> {
        return files
                .flatMap { file ->
                    file.transferTo(Paths.get(UPLOAD_ROOT, file.filename()).toFile())
                }
                .then()
    }

    fun deleteImage(filename: String): Mono<Void> {
        return Mono.fromRunnable {
            try {
                Files.deleteIfExists(Paths.get(UPLOAD_ROOT, filename))
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }



}
