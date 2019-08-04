
package com.imooc.miaosha.sds.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sbbGridlbVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sbbGridlbVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ewbhxh">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="bqybtsfehjjme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slzslhjmdse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqynsfehjmdse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqjmsfehjjmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsfyjhjmdse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsfyjzzsybzzs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsfyjxfsmdse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqyjsfehjjme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsfyjzzsmdse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqjmsfehjjme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sbbGridlbVOType", propOrder = {
    "ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse"
})
public class SbbGridlbVOType {

    @XmlElementRefs({
        @XmlElementRef(name = "bqjmsfehjjme", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsfyjhjmdse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqyjsfehjjme", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsfyjxfsmdse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqybtsfehjjme", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsfyjzzsybzzs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsfyjzzsmdse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "slzslhjmdse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqjmsfehjjmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqynsfehjmdse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ewbhxh", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse;

    /**
     * Gets the value of the ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEwbhxhOrBqybtsfehjjmeOrSlzslhjmdse().add(newItem);
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
     * 
     * 
     */
    public List<JAXBElement<String>> getEwbhxhOrBqybtsfehjjmeOrSlzslhjmdse() {
        if (ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse == null) {
            ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse = new ArrayList<JAXBElement<String>>();
        }
        return this.ewbhxhOrBqybtsfehjjmeOrSlzslhjmdse;
    }

}
