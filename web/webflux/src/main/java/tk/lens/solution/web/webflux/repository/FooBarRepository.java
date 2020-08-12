package tk.lens.solution.web.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import tk.lens.solution.web.webflux.model.FooBar;

public interface FooBarRepository extends ReactiveCrudRepository <FooBar,Long> {

}
	