package com.salsatechnology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeachProductRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeachProductRentalApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<AuthenticationFilter> authenticationFilterRegistration() {
//		FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
//		registration.setFilter(new AuthenticationFilter());
//		registration.addUrlPatterns("/*");
//		return registration;
//	}

}
