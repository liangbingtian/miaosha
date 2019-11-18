
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jxds_zzs_ybnsrxxVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jxds_zzs_ybnsrxxVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sbbinfo" type="{}sbbinfoType"/>
 *         &lt;element name="jxds_zzs_ybnsr_zb" type="{}jxds_zzs_ybnsr_zbType"/>
 *         &lt;element name="jxds_zzs_ybnsr_fb1" type="{}jxds_zzs_ybnsr_fb1Type"/>
 *         &lt;element name="jxds_zzs_ybnsr_fb2" type="{}jxds_zzs_ybnsr_fb2Type"/>
 *         &lt;element name="jxds_zzs_ybnsr_fb3" type="{}jxds_zzs_ybnsr_fb3Type"/>
 *         &lt;element name="jxds_zzs_ybnsr_fb4" type="{}jxds_zzs_ybnsr_fb4Type"/>
 *         &lt;element name="jxds_zzs_ybnsr_jmssbmxb" type="{}jxds_zzs_ybnsr_jmssbmxbType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jxds_zzs_ybnsrxxVOType", propOrder = {
    "sbbinfo",
    "jxdsZzsYbnsrZb",
    "jxdsZzsYbnsrFb1",
    "jxdsZzsYbnsrFb2",
    "jxdsZzsYbnsrFb3",
    "jxdsZzsYbnsrFb4",
    "jxdsZzsYbnsrJmssbmxb"
})
public class JxdsZzsYbnsrxxVOType {

    @XmlElement(required = true)
    protected SbbinfoType sbbinfo;
    @XmlElement(name = "jxds_zzs_ybnsr_zb", required = true)
    protected JxdsZzsYbnsrZbType jxdsZzsYbnsrZb;
    @XmlElement(name = "jxds_zzs_ybnsr_fb1", required = true)
    protected JxdsZzsYbnsrFb1Type jxdsZzsYbnsrFb1;
    @XmlElement(name = "jxds_zzs_ybnsr_fb2", required = true)
    protected JxdsZzsYbnsrFb2Type jxdsZzsYbnsrFb2;
    @XmlElement(name = "jxds_zzs_ybnsr_fb3", required = true)
    protected JxdsZzsYbnsrFb3Type jxdsZzsYbnsrFb3;
    @XmlElement(name = "jxds_zzs_ybnsr_fb4", required = true)
    protected JxdsZzsYbnsrFb4Type jxdsZzsYbnsrFb4;
    @XmlElement(name = "jxds_zzs_ybnsr_jmssbmxb", required = true)
    protected JxdsZzsYbnsrJmssbmxbType jxdsZzsYbnsrJmssbmxb;

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
     * 获取jxdsZzsYbnsrZb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrZbType }
     *     
     */
    public JxdsZzsYbnsrZbType getJxdsZzsYbnsrZb() {
        return jxdsZzsYbnsrZb;
    }

    /**
     * 设置jxdsZzsYbnsrZb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrZbType }
     *     
     */
    public void setJxdsZzsYbnsrZb(JxdsZzsYbnsrZbType value) {
        this.jxdsZzsYbnsrZb = value;
    }

    /**
     * 获取jxdsZzsYbnsrFb1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrFb1Type }
     *     
     */
    public JxdsZzsYbnsrFb1Type getJxdsZzsYbnsrFb1() {
        return jxdsZzsYbnsrFb1;
    }

    /**
     * 设置jxdsZzsYbnsrFb1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrFb1Type }
     *     
     */
    public void setJxdsZzsYbnsrFb1(JxdsZzsYbnsrFb1Type value) {
        this.jxdsZzsYbnsrFb1 = value;
    }

    /**
     * 获取jxdsZzsYbnsrFb2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrFb2Type }
     *     
     */
    public JxdsZzsYbnsrFb2Type getJxdsZzsYbnsrFb2() {
        return jxdsZzsYbnsrFb2;
    }

    /**
     * 设置jxdsZzsYbnsrFb2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrFb2Type }
     *     
     */
    public void setJxdsZzsYbnsrFb2(JxdsZzsYbnsrFb2Type value) {
        this.jxdsZzsYbnsrFb2 = value;
    }

    /**
     * 获取jxdsZzsYbnsrFb3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrFb3Type }
     *     
     */
    public JxdsZzsYbnsrFb3Type getJxdsZzsYbnsrFb3() {
        return jxdsZzsYbnsrFb3;
    }

    /**
     * 设置jxdsZzsYbnsrFb3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrFb3Type }
     *     
     */
    public void setJxdsZzsYbnsrFb3(JxdsZzsYbnsrFb3Type value) {
        this.jxdsZzsYbnsrFb3 = value;
    }

    /**
     * 获取jxdsZzsYbnsrFb4属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrFb4Type }
     *     
     */
    public JxdsZzsYbnsrFb4Type getJxdsZzsYbnsrFb4() {
        return jxdsZzsYbnsrFb4;
    }

    /**
     * 设置jxdsZzsYbnsrFb4属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrFb4Type }
     *     
     */
    public void setJxdsZzsYbnsrFb4(JxdsZzsYbnsrFb4Type value) {
        this.jxdsZzsYbnsrFb4 = value;
    }

    /**
     * 获取jxdsZzsYbnsrJmssbmxb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JxdsZzsYbnsrJmssbmxbType }
     *     
     */
    public JxdsZzsYbnsrJmssbmxbType getJxdsZzsYbnsrJmssbmxb() {
        return jxdsZzsYbnsrJmssbmxb;
    }

    /**
     * 设置jxdsZzsYbnsrJmssbmxb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JxdsZzsYbnsrJmssbmxbType }
     *     
     */
    public void setJxdsZzsYbnsrJmssbmxb(JxdsZzsYbnsrJmssbmxbType value) {
        this.jxdsZzsYbnsrJmssbmxb = value;
    }

}
