
package co.com.banco.soap.convenio.gas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Resultado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Resultado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referenciaFactura" type="{http://www.servicios.co/pagos/schemas}ReferenciaFactura"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resultado", propOrder = {
    "referenciaFactura",
    "mensaje"
})
public class Resultado {

    @XmlElement(required = true)
    protected ReferenciaFactura referenciaFactura;
    @XmlElement(required = true)
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad referenciaFactura.
     * 
     * @return
     *     possible object is
     *     {@link ReferenciaFactura }
     *     
     */
    public ReferenciaFactura getReferenciaFactura() {
        return referenciaFactura;
    }

    /**
     * Define el valor de la propiedad referenciaFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenciaFactura }
     *     
     */
    public void setReferenciaFactura(ReferenciaFactura value) {
        this.referenciaFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

}
