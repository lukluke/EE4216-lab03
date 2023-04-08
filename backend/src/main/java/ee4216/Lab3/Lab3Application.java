package ee4216.Lab3;

import ee4216.Lab3.jbdc.MovieDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}
        
       @Bean
        public MovieDao movieDao(JdbcTemplate jdbcTemplate) {
            return new MovieDao(jdbcTemplate);
        }

        
}
