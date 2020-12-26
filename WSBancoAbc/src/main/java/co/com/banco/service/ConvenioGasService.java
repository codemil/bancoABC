package co.com.banco.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.banco.soap.convenio.gas.Pago;
import co.com.banco.soap.convenio.gas.PagosInerface;
import co.com.banco.soap.convenio.gas.PagosService;
import co.com.banco.soap.convenio.gas.ReferenciaFactura;
import co.com.banco.soap.convenio.gas.Resultado;
import co.com.banco.soap.convenio.gas.ResultadoConsulta;

/**
 * Clase que representa un servicio para convenio de gas
 * 
 * @author Mquintero
 *
 */
@Service
public class ConvenioGasService {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ConvenioAguaService.class);

	/**
	 * Consultar factura de gas
	 * 
	 * @param obj
	 * @return
	 */
	public ResultadoConsulta consultar(Object obj) {
		ResultadoConsulta resultadoConsulta = new ResultadoConsulta();
		try {
			PagosService serviciosPagos = new PagosService();
			PagosInerface pagosInerface = serviciosPagos.getPagosPort();
			ObjectMapper mapper = new ObjectMapper();
			ReferenciaFactura referenciaFactura = mapper.convertValue(obj, ReferenciaFactura.class);
			resultadoConsulta = pagosInerface.cosultar(referenciaFactura);
			return resultadoConsulta;
		} catch (Exception e) {
			LOGGER.error("Error consultando factura de gas", e);
		}
		return resultadoConsulta;
	}

	/**
	 * Pagar factura de gas
	 * 
	 * @param obj
	 * @return
	 */
	public Resultado pagar(Object obj) {
		Resultado resultado = new Resultado();
		try {
			PagosService serviciosPagos = new PagosService();
			PagosInerface pagosInerface = serviciosPagos.getPagosPort();
			ObjectMapper mapper = new ObjectMapper();
			Pago pago = mapper.convertValue(obj, Pago.class);
			resultado = pagosInerface.pagar(pago);
			return resultado;
		} catch (Exception e) {
			LOGGER.error("Error pagando factura de gas", e);
		}
		return resultado;
	}

	/**
	 * Compensar factura de gas
	 * 
	 * @param obj
	 * @return
	 */
	public Resultado compensar(Object obj) {
		Resultado resultado = new Resultado();
		try {
			PagosService serviciosPagos = new PagosService();
			PagosInerface pagosInerface = serviciosPagos.getPagosPort();
			ObjectMapper mapper = new ObjectMapper();
			Pago pago = mapper.convertValue(obj, Pago.class);
			resultado = pagosInerface.compensar(pago);
			return resultado;
		} catch (Exception e) {
			LOGGER.error("Error compensando factura de gas", e);
		}
		return resultado;
	}
}
