package com.jackhodge.DataViewTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;


// SpringBootApplication is a convienecnce tag which adds
// ... config (tag this class as source of bean defs for app context
// ... , enableautoconfig (start adding beans based on classpath settings)
//   ... , componentscan (find controllers)


/*
Spring is a container containing Objects which it manages
Spring is responsible for creation of objects using a Factory Pattern.

Object -> Factory -----> Configuration
The developer typically specifies the Object, and if, for example, that object needs has-a object within,
spring will call a factory to create it for you based on the configuration you might have supplied.

Any object that is instantiated, managed, or assembled by the Spring IoC container is called a Bean.

Controllers
   -- Usually via the Spring MVC, they handle incoming HTTP requests
Services
   -- Used to define buisness logic
Repositories
   -- Used to encapuslate storage, retrieval, and search behavior. Emulates a collection of objects
Components
   -- Generic term: any managed object can be considered a componenet


Configuration tips:
@Configuration
then,
@Bean -- before a method to denote a method as repsponsible for creating the bean



ApplicationcContext:




 */
@SpringBootApplication
@EnableJpaRepositories
@Controller
public class DataViewToolApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataViewToolApplication.class, args);
	}
}