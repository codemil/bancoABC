
package co.com.banco.soap.convenio.gas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReferenciaFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReferenciaFactura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referenciaFactura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenciaFactura", propOrder = {
    "referenciaFactura"
})
public class ReferenciaFactura {

    @XmlElement(required = true)
    protected String referenciaFactura;

    /**
     * Obtiene el valor de la propiedad referenciaFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaFactura() {
        return referenciaFactura;
    }

    /**
     * Define el valor de la propiedad referenciaFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaFactura(String value) {
        this.referenciaFactura = value;
    }

}
