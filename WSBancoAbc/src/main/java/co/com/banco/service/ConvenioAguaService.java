package co.com.banco.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.banco.dto.PeticionCompensacionAguaDTO;
import co.com.banco.dto.PeticionConsultaAguaDTO;
import co.com.banco.dto.PeticionPagoAguaDTO;
import co.com.banco.dto.RespuestaConpensacionAguaDTO;
import co.com.banco.dto.RespuestaConsultaAguaDTO;
import co.com.banco.dto.RespuestaPagoAguaDTO;
import co.com.banco.util.ClientService;

/**
 * Clase que representa un servicio para convenio de agua
 * @author Mquintero
 *
 */
@Service
public class ConvenioAguaService {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ConvenioAguaService.class);
	
	@Value("${apiConvenioAgua}")
	private String apiConvenioAgua;
	
	@Autowired
	private ClientService clientService;
	
	/**
	 * Consultar factura de agua
	 * @param obj
	 * @return
	 */
	public RespuestaConsultaAguaDTO consultar(Object obj) {
		RespuestaConsultaAguaDTO respuestaPagoAguaDTO = new RespuestaConsultaAguaDTO();
		try {
			Map<String, String> headers = new HashMap<>();
		    headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		    ObjectMapper mapper = new ObjectMapper();
		    PeticionConsultaAguaDTO consultaAgua = mapper.convertValue(obj, PeticionConsultaAguaDTO.class);
		    respuestaPagoAguaDTO = clientService.getClient(apiConvenioAgua + "/payments/" + consultaAgua.getIdFactura(), headers, RespuestaConsultaAguaDTO.class);
			return respuestaPagoAguaDTO;
		} catch (Exception e) {
			LOGGER.error("Error consultando factura de agua", e);
		}
		return respuestaPagoAguaDTO;
	}
	
	/**
	 * Pagar factura de agua
	 * @param obj
	 * @return
	 */
	public RespuestaPagoAguaDTO pagar(Object obj) {
		RespuestaPagoAguaDTO respuestaPagoAguaDTO = new RespuestaPagoAguaDTO();
		try {
			Map<String, String> headers = new HashMap<>();
		    headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		    ObjectMapper mapper = new ObjectMapper();
		    PeticionPagoAguaDTO peticionPagoAgua = mapper.convertValue(obj, PeticionPagoAguaDTO.class);
			respuestaPagoAguaDTO = clientService.postClient(apiConvenioAgua + "/payments/" + peticionPagoAgua.getIdFactura(), peticionPagoAgua, headers, RespuestaPagoAguaDTO.class);
			return respuestaPagoAguaDTO;
		} catch (Exception e) {
			LOGGER.error("Error pagando factura de agua", e);
		}
		return respuestaPagoAguaDTO;
	}
	
	/**
	 * Compensar factura de agua
	 * @param obj
	 * @return
	 */
	public RespuestaConpensacionAguaDTO compensar(Object obj) {
		 RespuestaConpensacionAguaDTO respuestaConpensacionAguaDTO = new RespuestaConpensacionAguaDTO();
		try {
			Map<String, String> headers = new HashMap<>();
		    headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		    ObjectMapper mapper = new ObjectMapper();
		    PeticionCompensacionAguaDTO compensacionAgua = mapper.convertValue(obj, PeticionCompensacionAguaDTO.class);
		    respuestaConpensacionAguaDTO = clientService.deleteClient(apiConvenioAgua + "/payments/" + compensacionAgua.getIdFactura(), compensacionAgua, headers, RespuestaConpensacionAguaDTO.class);
			return respuestaConpensacionAguaDTO;
		} catch (Exception e) {
			LOGGER.error("Error compensando factura de agua", e);
		}
		return respuestaConpensacionAguaDTO;
	}
}
