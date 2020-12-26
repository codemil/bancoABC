package co.com.banco.controller;

import javax.ws.rs.core.MediaType;

import org.apache.camel.BeanInject;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import co.com.banco.process.ConvenioAguaCompensacionProcess;
import co.com.banco.process.ConvenioAguaConsultaProcess;
import co.com.banco.process.ConvenioAguaPagoProcess;
import co.com.banco.process.ConvenioGasConsultaProcess;
import co.com.banco.process.ConvenioGasPagoProcess;
import co.com.banco.util.Constante;

/**
 * Clase que representa el enrutamiento de los servicios dependiedo del convenio
 * @author Mquintero
 *
 */
@Configuration
@Component
public class EnrutadorController extends RouteBuilder {

	private static final String ENDPOINT = "/banco";

	@BeanInject
	private ConvenioGasConsultaProcess convenioGasConsultaProcess;
	
	@BeanInject
	private ConvenioGasPagoProcess convenioGasPagoProcess;
	
	@BeanInject
	private ConvenioAguaConsultaProcess convenioAguaConsultaProcess;
	
	@BeanInject
	private ConvenioAguaPagoProcess convenioAguaPagoProcess;
	
	@BeanInject
	private ConvenioAguaCompensacionProcess convenioAguaCompensacionProcess;
	
	/**
	 * Método encargado de configurar las diferentes rutas
	 */
	@Override
	public void configure() throws Exception {

	        restConfiguration()
	        .component("servlet")
	        .enableCORS(true)
	        .corsHeaderProperty("Access-Control-Allow-Origin", "*")
	        .corsHeaderProperty("Access-Control-Allow-Headers", "*")
	        .corsHeaderProperty("Access-Control-Allow-Methods", "*")
	            .bindingMode(RestBindingMode.auto);
	        
	        Predicate isConvenioGas = header("convenio").isEqualTo(Constante.CONVENIO_GAS);
	        Predicate isConvenioAgua = header("convenio").isEqualTo(Constante.CONVENIO_AGUA);
	        
	        rest(ENDPOINT).post("/consulta").produces(MediaType.APPLICATION_JSON).type(Object.class).outType(ResponseEntity.class)
	        .route()
	        .choice()
	        .when(isConvenioGas)
	        .to("direct:consultaConvenioGas")
	        .when(isConvenioAgua)
	        .to("direct:consultaConvenioAgua");
	        
	        rest(ENDPOINT).post("/pago").produces(MediaType.APPLICATION_JSON).type(Object.class).outType(ResponseEntity.class)
	        .route()
	        .choice()
	        .when(isConvenioGas)
	        .to("direct:pagoConvenioGas")
	        .when(isConvenioAgua)
	        .to("direct:pagoConvenioAgua");

	        rest(ENDPOINT).post("/compensado").produces(MediaType.APPLICATION_JSON).type(Object.class).outType(ResponseEntity.class)
	        .route()
	        .choice()
	        .when(isConvenioGas)
	        .to("direct:compensadoConvenioGas")
	        .when(isConvenioAgua)
	        .to("direct:compensadoConvenioAgua");

	        
	       from("direct:consultaConvenioGas")
	          .log(LoggingLevel.INFO, "Consultando factura ${header.convenio}")
	          .process(convenioGasConsultaProcess).end();
	       
	       from("direct:consultaConvenioAgua")
	       .log(LoggingLevel.INFO, "Consultando factura ${header.convenio}" )
	       .process(convenioAguaConsultaProcess)
	       .end();
	       
	       from("direct:pagoConvenioGas")
	          .log(LoggingLevel.INFO, "Pagando factura ${header.convenio}")
	          .process(convenioGasPagoProcess)
	          .end();
	       
	       from("direct:pagoConvenioAgua")
	          .log(LoggingLevel.INFO, "Pagando factura ${header.convenio}")
	          .process(convenioAguaPagoProcess)
	          .end();
	       
	       from("direct:compensadoConvenioGas")
	          .log(LoggingLevel.INFO, "Eliminando factura ${header.convenio}")
	          .process(convenioGasPagoProcess)
	          .end();
	       
	       from("direct:compensadoConvenioAgua")
	          .log(LoggingLevel.INFO, "Eliminando factura ${header.convenio}")
	          .process(convenioAguaCompensacionProcess)
		       .end();
	}
}
