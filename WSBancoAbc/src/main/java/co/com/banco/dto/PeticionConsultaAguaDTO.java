package co.com.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * DTO para la petición de consulta de factura de agua
 * @author Mquintero
 *
 */
@JsonIgnoreProperties
@Data
public class PeticionConsultaAguaDTO {

	private long idFactura;
	
}
