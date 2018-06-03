package my.history.library.service;

import java.time.Duration;
import java.util.List;

import my.history.library.Image;
import org.junit.Test;
import reactor.core.publisher.Flux;

import org.springframework.core.io.Resource;
import org.springframework.http.codec.multipart.FilePart;

/**
 * @author Greg Turnquist
 */
// tag::1[]
public class BlockingImageService {

	private final ImageService imageService;

	public BlockingImageService(ImageService imageService) {
		this.imageService = imageService;
	}
	// end::1[]

	// tag::2[]
	public List<Image> findAllImages() {
		return imageService
				.findAllImages()
				.collectList()
				.block(Duration.ofSeconds(10));
	}
	// end::2[]

	// tag::3[]
	public Resource findOneImage(String filename) {
		return imageService
				.findOneImage(filename)
				.block(Duration.ofSeconds(30));
	}
	// end::3[]

	// tag::4[]
	public void createImage(List<FilePart> files) {
		imageService
				.createImage(Flux.fromIterable(files))
				.block(Duration.ofMinutes(1));
	}
	// end::4[]

	// tag::5[]
	public void deleteImage(String filename) {
		imageService
				.deleteImage(filename)
				.block(Duration.ofSeconds(20));
	}
	// end::6[]
}
