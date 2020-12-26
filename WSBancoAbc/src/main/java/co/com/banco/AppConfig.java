package co.com.banco;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.swagger.DefaultCamelSwaggerServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que representa las configuraciones de la app
 * @author Mquintero
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Bean para configurar swagger
	 * @return
	 */
	@Bean
    public ServletRegistrationBean<DefaultCamelSwaggerServlet> swaggerServlet() {
        ServletRegistrationBean<DefaultCamelSwaggerServlet> swagger = new ServletRegistrationBean<DefaultCamelSwaggerServlet>(new DefaultCamelSwaggerServlet(), "/api-doc/*");
        Map<String, String> params = new HashMap<>();
        params.put("resourcePackage", "co.com.banco.controller");
        params.put("base.path", "");
        params.put("api.title", "banco abc");
        params.put("api.description", "banco abc");
        params.put("api.termsOfServiceUrl", "termsOfServiceUrl");
        params.put("api.license", "");
        params.put("api.licenseUrl", "");
        swagger.setInitParameters(params);
        return swagger;
    }

}
