
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

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
 *         &lt;element name="sbbname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companycode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sbbname",
    "companycode",
    "nsqxdm"
})
public class SbbinfoType {

    @XmlElement(required = true)
    protected String sbbname;
    @XmlElement(required = true)
    protected String companycode;
    @XmlElement(required = true)
    protected String nsqxdm;

    /**
     * 获取sbbname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbbname() {
        return sbbname;
    }

    /**
     * 设置sbbname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbbname(String value) {
        this.sbbname = value;
    }

    /**
     * 获取companycode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanycode() {
        return companycode;
    }

    /**
     * 设置companycode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanycode(String value) {
        this.companycode = value;
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
