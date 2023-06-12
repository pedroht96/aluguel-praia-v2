package com.salsatechnology;

import com.salsatechnology.filter.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeachProductRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeachProductRentalApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthenticationFilter> authenticationFilterRegistration() {
		FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new AuthenticationFilter());
		registration.addUrlPatterns("/*");
		return registration;
	}

}
