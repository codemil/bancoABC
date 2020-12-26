package co.com.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * DTO para la respuesta de consulta de factura de agua
 * @author Mquintero
 *
 */
@JsonIgnoreProperties
@Data
public class RespuestaConsultaAguaDTO {

	private long idFactura;
	
    private double valorFactura;
    
}
