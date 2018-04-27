package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class DataSourceMySQLConfig.
 */
@Configuration
public class DataSourceMySQLConfig {
	
	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/sirh_paie");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
}


