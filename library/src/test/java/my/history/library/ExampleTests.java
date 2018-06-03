package my.history.library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

/**
 * @author Greg Turnquist
 */
public class ExampleTests {

	@Test
	public void data1() {
		// tag::1[]
		Flux.just("alpha", "bravo", "charlie")
			.subscribe(System.out::println);
		// end::1[]
	}

	@Test
	public void data2() {
		// tag::2[]
		String[] items = new String[]{"alpha", "bravo", "charlie"};
		Flux.fromArray(items)
			.subscribe(System.out::println);
		// end::2[]
	}

	@Test
	public void data3() {
		// tag::3[]
		List<String> items = Arrays.asList("alpha", "bravo", "charlie");
		Flux.fromIterable(items)
			.subscribe(System.out::println);
		// end::3[]
	}

	@Test
	public void data4() {
		// tag::4[]
		Stream<String> items = Arrays.asList("alpha", "bravo", "charlie").stream();
		Flux.fromStream(items)
			.subscribe(System.out::println);
		// end::4[]
	}

	@Test
	public void data5() {
		// tag::5[]
		Flux.just("alpha", "bravo", "charlie")
			.subscribe(System.out::println);
		// end::5[]
	}

	@Test
	public void data6() {
		// tag::6[]
		Flux.just("alpha", "bravo", "charlie")
			.map(String::toUpperCase)
			.flatMap(s -> Flux.fromArray(s.split("")))
			.groupBy(String::toString)
			.sort(Comparator.comparing(GroupedFlux::key))
			.flatMap(group -> Mono.just(group.key()).zipWith(group.count()))
			.map(keyAndCount -> keyAndCount.getT1() + " => " + keyAndCount.getT2())
			.subscribe(System.out::println);
		// end::6[]
	}

}
