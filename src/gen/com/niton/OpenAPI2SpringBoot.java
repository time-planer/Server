package com.niton;

import javax.servlet.Filter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.planetj.servlet.filter.compression.CompressingFilter;

@SpringBootApplication
@ComponentScan(basePackages = { "com.niton", "com.niton.api", "com.niton.conf" })
public class OpenAPI2SpringBoot extends SpringBootServletInitializer implements CommandLineRunner {

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}

	public static final boolean logDB = true;

	public static void main(String[] args) throws Exception {
		new SpringApplication(OpenAPI2SpringBoot.class).run(args);
	}

	@Bean
	public Filter compressingFilter() {
	    CompressingFilter compressingFilter = new CompressingFilter();
	    return compressingFilter;
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}
	
	@Bean
	public WebMvcConfigurer webConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*").allowCredentials(true)
						.allowedMethods("PUT","GET","POST","PATCH","UPDATE","OPTIONS","HEADERS")
						.allowedHeaders("Content-Type","user-key","user_key","*");
				registry.addMapping("/").allowedOrigins("*").allowCredentials(true)
						.allowedMethods("PUT","GET","POST","PATCH","UPDATE","OPTIONS","HEADERS")
						.allowedHeaders("Content-Type","user-key","user_key","*");
				registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
						.allowedMethods("PUT","GET","POST","PATCH","UPDATE","OPTIONS","HEADERS")
						.allowedHeaders("Content-Type","user-key","user_key","*");
			}
		};
	}

}
