package tk.lens.solution.web.webflux.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tk.lens.solution.web.webflux.model.FooBar;
import tk.lens.solution.web.webflux.repository.FooBarRepository;

@RequestMapping("/foobar")
@RestController
public class FooBarController {
	
	@Autowired
	private FooBarRepository fooBarRepository;
	
	@GetMapping("/create")
	public Mono<FooBar> create() {
		return this.fooBarRepository.save(new FooBar());
	}
}
