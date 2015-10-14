package org.samples.swaggerjava.config;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Main configuration class for the application. Turns on @Component scanning,
 * loads externalized config.properties.
 */

@Configuration
@ComponentScan(basePackages = "org.samples.swaggerjava", excludeFilters = { @Filter(Configuration.class) })
@PropertySource("classpath:config.properties")
public class MainConfig {

	@Inject
	private Environment environment;

	@PostConstruct
	public void init() {
		String someprop = environment.getProperty("someprop");
	}

}
