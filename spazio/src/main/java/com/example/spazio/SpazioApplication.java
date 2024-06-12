package com.example.spazio;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpazioApplication {

	private static Logger logger = LoggerFactory.getLogger(SpazioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpazioApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT);
		return new ModelMapper();
	}

	@Configuration
	public class AppConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("http://localhost:5173", "https://api.curso.spazioserver.online", "https://sprint-ii.vercel.app/", "https://www.spazioserver.app/") //cambiar a la ruta desde donde se manda la solucitud
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.allowCredentials(true);
		}
	}


}