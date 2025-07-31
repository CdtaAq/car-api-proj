package com.codility.external;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ReactiveCrudRepository<Car, String> {
// ReactiveCrudRepository provides all the basic CRUD operations:
// - Mono<Car> save(Car car)
// - Mono<Car> findById(String id)
// - Flux<Car> findAll()
// - Mono<Void> deleteById(String id)
// - void deleteAll()
// - Mono<Boolean> existsById(String id)
// - Mono<Long> count()
}
