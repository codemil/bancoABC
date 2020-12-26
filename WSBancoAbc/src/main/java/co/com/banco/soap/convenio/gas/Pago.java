
package co.com.banco.soap.convenio.gas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Pago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Pago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referenciaFactura" type="{http://www.servicios.co/pagos/schemas}ReferenciaFactura"/>
 *         &lt;element name="totalPagar" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pago", propOrder = {
    "referenciaFactura",
    "totalPagar"
})
public class Pago {

    @XmlElement(required = true)
    protected ReferenciaFactura referenciaFactura;
    protected double totalPagar;

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
     * Obtiene el valor de la propiedad totalPagar.
     * 
     */
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * Define el valor de la propiedad totalPagar.
     * 
     */
    public void setTotalPagar(double value) {
        this.totalPagar = value;
    }

}
