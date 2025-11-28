package com.equinix.xscale.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class ApplicationContextTest {
	@Mock
	private ConfigurableApplicationContext contextMock;

	@InjectMocks
	private ApplicationContext applicationContext;

	@Test
	void testMain() {
		try (MockedStatic<SpringApplication> app = mockStatic(SpringApplication.class)) {
			app.when(() -> SpringApplication.run(org.springframework.context.ApplicationContext.class)).thenReturn(contextMock);
			assertThatNoException().isThrownBy(() -> ApplicationContext.main(new String[] {}));
		}
	}

	@Test
	void testExitApplication() {
		try (MockedStatic<SpringApplication> app = mockStatic(SpringApplication.class)) {
			app.when(() -> SpringApplication.exit(eq(contextMock), any(ExitCodeGenerator.class)))
					.thenReturn(0);
			assertThatNoException().isThrownBy(applicationContext::exitApplication);
		}
	}
}