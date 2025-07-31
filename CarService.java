package com.codility.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarService {

```
@Autowired
private CarRepository carRepository;

// Return all cars in the database
public Flux<Car> findAll() {
return carRepository.findAll();
}

// Return the car with the given id in the database or return an empty Mono if the car is not found
public Mono<Car> findById(String id) {
return carRepository.findById(id);
}

// Save the car in the database and return the saved instance as a result
// Make sure that the id is null when the new car is saved, otherwise the car with the id that you have passed will be updated
public Mono<Car> create(String name) {
Car newCar = new Car();
newCar.setName(name);
// Ensure id is null for new cars
newCar.setId(null);
return carRepository.save(newCar);
}

// Find a car in the database (use the findById method that you have already implemented) and, if it exists,
// update its name with the given name. Return the updated instance as a result
public Mono<Car> update(String id, String name) {
return findById(id)
.flatMap(existingCar -> {
existingCar.setName(name);
return carRepository.save(existingCar);
});
}

// Find a car in the database and, if it exists, delete it.
// Return the deleted car if it existed; otherwise return an empty Mono
public Mono<Car> delete(String id) {
return findById(id)
.flatMap(existingCar ->
carRepository.deleteById(id)
.then(Mono.just(existingCar))
);
}
```

}
