package com.equinix.xscale.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationContext {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(ApplicationContext.class, args);
	}

	public int exitApplication() {
		return SpringApplication.exit(context, () -> 0);
	}
}
