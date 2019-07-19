
package com.imooc.miaosha.sds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jsds_yhsxxVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jsds_yhsxxVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sbbinfo" type="{}sbbinfoType"/>
 *         &lt;element name="jsds_yhs_sbb" type="{}jsds_yhs_sbbType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jsds_yhsxxVOType", propOrder = {
    "sbbinfo",
    "jsdsYhsSbb"
})
public class JsdsYhsxxVOType {

    @XmlElement(required = true)
    protected SbbinfoType sbbinfo;
    @XmlElement(name = "jsds_yhs_sbb", required = true)
    protected JsdsYhsSbbType jsdsYhsSbb;

    /**
     * 获取sbbinfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SbbinfoType }
     *     
     */
    public SbbinfoType getSbbinfo() {
        return sbbinfo;
    }

    /**
     * 设置sbbinfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SbbinfoType }
     *     
     */
    public void setSbbinfo(SbbinfoType value) {
        this.sbbinfo = value;
    }

    /**
     * 获取jsdsYhsSbb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JsdsYhsSbbType }
     *     
     */
    public JsdsYhsSbbType getJsdsYhsSbb() {
        return jsdsYhsSbb;
    }

    /**
     * 设置jsdsYhsSbb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JsdsYhsSbbType }
     *     
     */
    public void setJsdsYhsSbb(JsdsYhsSbbType value) {
        this.jsdsYhsSbb = value;
    }

}
