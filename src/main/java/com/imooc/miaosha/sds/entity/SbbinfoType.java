
package com.imooc.miaosha.sds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sbbinfoType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sbbinfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sbzlbh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssqq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssqz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jtnsrsbh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nsrsbh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nsqxdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sbbinfoType", propOrder = {
    "sbzlbh",
    "ssqq",
    "ssqz",
    "jtnsrsbh",
    "nsrsbh",
    "area",
    "nsqxdm"
})
public class SbbinfoType {

    @XmlElement(required = true)
    protected String sbzlbh;
    @XmlElement(required = true)
    protected String ssqq;
    @XmlElement(required = true)
    protected String ssqz;
    @XmlElement(required = true)
    protected String jtnsrsbh;
    @XmlElement(required = true)
    protected String nsrsbh;
    @XmlElement(required = true)
    protected String area;
    @XmlElement(required = true)
    protected String nsqxdm;

    /**
     * 获取sbzlbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbzlbh() {
        return sbzlbh;
    }

    /**
     * 设置sbzlbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbzlbh(String value) {
        this.sbzlbh = value;
    }

    /**
     * 获取ssqq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsqq() {
        return ssqq;
    }

    /**
     * 设置ssqq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsqq(String value) {
        this.ssqq = value;
    }

    /**
     * 获取ssqz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsqz() {
        return ssqz;
    }

    /**
     * 设置ssqz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsqz(String value) {
        this.ssqz = value;
    }

    /**
     * 获取jtnsrsbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJtnsrsbh() {
        return jtnsrsbh;
    }

    /**
     * 设置jtnsrsbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJtnsrsbh(String value) {
        this.jtnsrsbh = value;
    }

    /**
     * 获取nsrsbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNsrsbh() {
        return nsrsbh;
    }

    /**
     * 设置nsrsbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNsrsbh(String value) {
        this.nsrsbh = value;
    }

    /**
     * 获取area属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置area属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArea(String value) {
        this.area = value;
    }

    /**
     * 获取nsqxdm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNsqxdm() {
        return nsqxdm;
    }

    /**
     * 设置nsqxdm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNsqxdm(String value) {
        this.nsqxdm = value;
    }

}
