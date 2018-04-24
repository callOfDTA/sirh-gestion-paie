package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("dev.paie.service")
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {
}
