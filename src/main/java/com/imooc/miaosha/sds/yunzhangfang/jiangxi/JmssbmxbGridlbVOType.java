
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jmssbmxbGridlbVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jmssbmxbGridlbVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ewbhxh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqfse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqsjdjse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qmye" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qcye" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqydjse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsxzdmjmc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qcyemzzzsxmxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qmyemse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqsjdjsemsxsedydjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqfsemsxsekcxmbqsjkcje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqydjsekchmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsxzdmjmcmsxzdmjmc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jmssbmxbGridlbVOType", propOrder = {
    "ewbhxhOrBqfseOrBqsjdjse"
})
public class JmssbmxbGridlbVOType {

    @XmlElementRefs({
        @XmlElementRef(name = "bqsjdjse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ewbhxh", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqfsemsxsekcxmbqsjkcje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqfse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qmye", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qcyemzzzsxmxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsxzdmjmc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsxzdmjmcmsxzdmjmc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqydjse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqydjsekchmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qcye", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qmyemse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqsjdjsemsxsedydjxse", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> ewbhxhOrBqfseOrBqsjdjse;

    /**
     * Gets the value of the ewbhxhOrBqfseOrBqsjdjse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ewbhxhOrBqfseOrBqsjdjse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEwbhxhOrBqfseOrBqsjdjse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getEwbhxhOrBqfseOrBqsjdjse() {
        if (ewbhxhOrBqfseOrBqsjdjse == null) {
            ewbhxhOrBqfseOrBqsjdjse = new ArrayList<JAXBElement<String>>();
        }
        return this.ewbhxhOrBqfseOrBqsjdjse;
    }

}
