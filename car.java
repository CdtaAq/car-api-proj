package com.codility.external;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(“car”)
public class Car {

```
@Id
private String id;
private String name;

// Default constructor
public Car() {}

// Constructor with name
public Car(String name) {
this.name = name;
}

// Getters and setters
public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

@Override
public String toString() {
return "Car{" +
"id='" + id + '\'' +
", name='" + name + '\'' +
'}';
}
```

}
