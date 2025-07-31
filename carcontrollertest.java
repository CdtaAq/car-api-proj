package com.codility.external;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(CarController.class)
@SpringJUnitConfig
public class CarControllerTest {

```
@Autowired
private WebTestClient webTestClient;

@MockBean
private CarService carService;

@Test
public void testFindAll() {
Car car1 = new Car("Toyota");
car1.setId("1");
Car car2 = new Car("Honda");
car2.setId("2");

Mockito.when(carService.findAll())
.thenReturn(Flux.just(car1, car2));

webTestClient.get()
.uri("/cars")
.accept(MediaType.APPLICATION_JSON)
.exchange()
.expectStatus().isOk()
.expectHeader().contentType(MediaType.APPLICATION_JSON)
.expectBodyList(Car.class)
.hasSize(2);
}

@Test
public void testFindById() {
Car car = new Car("Toyota");
car.setId("1");

Mockito.when(carService.findById("1"))
.thenReturn(Mono.just(car));

webTestClient.get()
.uri("/cars/1")
.accept(MediaType.APPLICATION_JSON)
.exchange()
.expectStatus().isOk()
.expectHeader().contentType(MediaType.APPLICATION_JSON)
.expectBody(Car.class)
.isEqualTo(car);
}

@Test
public void testCreate() {
Car car = new Car("Toyota");
car.setId("1");

Mockito.when(carService.create("Toyota"))
.thenReturn(Mono.just(car));

webTestClient.post()
.uri("/cars?name=Toyota")
.accept(MediaType.APPLICATION_JSON)
.exchange()
.expectStatus().isOk()
.expectHeader().contentType(MediaType.APPLICATION_JSON)
.expectBody(Car.class)
.isEqualTo(car);
}

@Test
public void testUpdate() {
Car car = new Car("Honda");
car.setId("1");

Mockito.when(carService.update("1", "Honda"))
.thenReturn(Mono.just(car));

webTestClient.put()
.uri("/cars/1?name=Honda")
.accept(MediaType.APPLICATION_JSON)
.exchange()
.expectStatus().isOk()
.expectHeader().contentType(MediaType.APPLICATION_JSON)
.expectBody(Car.class)
.isEqualTo(car);
}

@Test
public void testDelete() {
Car car = new Car("Toyota");
car.setId("1");

Mockito.when(carService.delete("1"))
.thenReturn(Mono.just(car));

webTestClient.delete()
.uri("/cars/1")
.accept(MediaType.APPLICATION_JSON)
.exchange()
.expectStatus().isOk()
.expectHeader().contentType(MediaType.APPLICATION_JSON)
.expectBody(Car.class)
.isEqualTo(car);
}
```

}
