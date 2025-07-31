package com.codility.external;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class CarController {

```
private final MediaType mediaType = MediaType.APPLICATION_JSON;
private final CarService carService;

public CarController(CarService carService) {
this.carService = carService;
}

// Change signature to return Flux instead of void
// Produce APPLICATION_JSON_VALUE as MediaType for all methods unless stated otherwise
@GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public Flux<Car> findAll() {
return carService.findAll();
}

// Change signature to return Mono<Car> instead of void and accept String id parameter
@GetMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Mono<Car> findById(@PathVariable String id) {
return carService.findById(id);
}

// Change signature to return Mono<Car> instead of void and accept String name parameter
@PostMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public Mono<Car> create(@RequestParam String name) {
return carService.create(name);
}

// Change signature to return Mono<Car> instead of void and accept String id and String name parameters
@PutMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Mono<Car> update(@PathVariable String id, @RequestParam String name) {
return carService.update(id, name);
}

// Change signature to return Mono<Car> instead of void and accept String id parameter
@DeleteMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Mono<Car> delete(@PathVariable String id) {
return carService.delete(id);
}
```

}
