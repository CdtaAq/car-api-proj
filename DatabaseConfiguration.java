package com.codility.external;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class DatabaseConfig extends AbstractR2dbcConfiguration {

```
@Bean
public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
initializer.setConnectionFactory(connectionFactory);

// Create table on startup
ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
populator.addScript(new ClassPathResource("schema.sql"));
// Optionally add initial data
// populator.addScript(new ClassPathResource("data.sql"));

initializer.setDatabasePopulator(populator);
return initializer;
}
```

}
