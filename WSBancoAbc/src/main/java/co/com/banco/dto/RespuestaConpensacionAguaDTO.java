package co.com.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * DTO para la respuesta de compensacion de factura de agua
 * @author Mquintero
 *
 */
@JsonIgnoreProperties
@Data
public class RespuestaConpensacionAguaDTO {

	private long idFactura;
    
	private String mensaje;
    
}
