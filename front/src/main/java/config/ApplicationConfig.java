package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Nico on 09/02/2016.
 */
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = {"config","controller","servlet","services"})
@EntityScan(basePackages = {"entities"})
public class ApplicationConfig  {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationConfig.class, args);
    }

}
