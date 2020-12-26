package co.com.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * DTO para la petición de compensacion de factura de agua
 * @author Mquintero
 *
 */
@JsonIgnoreProperties
@Data
public class PeticionCompensacionAguaDTO {

	private long idFactura;
	
	private double valorFactura;
	
}
