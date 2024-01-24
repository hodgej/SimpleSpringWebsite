package com.jackhodge.DataViewTool;

import com.jackhodge.DataViewTool.repository.PersonRepository;
import com.jackhodge.DataViewTool.model.Person;

import com.jackhodge.DataViewTool.service.PopulateDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



// SpringBootApplication is a convienecnce tag which adds
// ... config (tag this class as source of bean defs for app context
// ... , enableautoconfig (start adding beans based on classpath settings)
//   ... , componentscan (find controllers)


@SpringBootApplication
@EnableJpaRepositories
@Controller
public class DataViewToolApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataViewToolApplication.class, args);
	}
}