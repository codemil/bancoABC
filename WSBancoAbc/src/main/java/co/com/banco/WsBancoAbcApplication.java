package co.com.banco;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Clase principal de la app
 * @author Mquintero
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan("co.com.banco.controller")
@ComponentScan("co.com.banco.service")
public class WsBancoAbcApplication {
	
	@Autowired
	CamelContext camelContext;

	public static void main(String[] args) {
		SpringApplication.run(WsBancoAbcApplication.class, args);
	}

}
