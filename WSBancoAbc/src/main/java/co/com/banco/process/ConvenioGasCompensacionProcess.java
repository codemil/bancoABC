package co.com.banco.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.banco.service.ConvenioGasService;

/**
 * Clase que representa un process para compensación de factura de gas
 * @author Mquintero
 *
 */
@Component
public class ConvenioGasCompensacionProcess  implements Processor {

	@Autowired
	private ConvenioGasService convenioGasService; 
	
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setBody(convenioGasService.compensar(exchange.getIn().getBody(Object.class)));		
	}

}
