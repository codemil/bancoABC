package co.com.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * DTO para la petición de pago de factura de agua
 * @author Mquintero
 *
 */
@JsonIgnoreProperties
@Data
public class PeticionPagoAguaDTO {
	
	private long idFactura;
    
	private double valorFactura;
    
}
