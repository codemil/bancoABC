package co.com.banco.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.banco.service.ConvenioAguaService;

/**
 * Clase que representa un process para compensación de factura de agua
 * @author Mquintero
 *
 */
@Component
public class ConvenioAguaCompensacionProcess implements Processor {

	@Autowired
	private ConvenioAguaService convenioAguaService;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setBody(convenioAguaService.compensar(exchange.getIn().getBody(Object.class)));	
	}

}
