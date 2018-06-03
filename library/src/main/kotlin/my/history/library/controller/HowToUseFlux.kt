package my.history.library.controller

import my.history.library.Image
import my.history.library.service.HowToUseFluxService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@RestController
class HowToUseFlux(private val howToUseFluxService: HowToUseFluxService){

    private val log = LoggerFactory.getLogger(HowToUseFlux::class.java)


    @GetMapping("/api/sample")
    fun sample() = howToUseFluxService.sample()

    @GetMapping("/api/images")
    fun images(): Flux<Image> {
        return Flux.just<Image>(
                Image(1, "learning-spring-boot-cover.jpg"),
                Image(2, "learning-spring-boot-2nd-edition-cover.jpg"),
                Image(3, "bazinga.png")
        )
    }

    // tag::post[]
    @PostMapping("/api/images")
    fun create(@RequestBody images: Image): Mono<Void> {
        return images
                .toMono()
                .map { image ->
                    log.info("We will save $image to a Reactive database soon!")
                    image}
                .then()
    }
}

