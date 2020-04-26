package org.tensquare_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tensquare.utils.IdWorker;
import com.tensquare.utils.JwtUtils;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ){
       SpringApplication.run(App.class, args);
    }
    
    @Bean
	public IdWorker idWorker() {
		return new IdWorker();
	}
    
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public JwtUtils jwtUtils() {
    	return new JwtUtils();
    }

}
