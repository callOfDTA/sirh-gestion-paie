package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppConfig.
 */
@Configuration
@Import(ServicesConfig.class)
@EnableWebMvc
@ComponentScan("dev.paie.web")
public class WebAppConfig {

	/**
	 * View resolver.
	 *
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}