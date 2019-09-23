
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jxds_zzs_ybnsr_jmssbmxbType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jxds_zzs_ybnsr_jmssbmxbType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jmssbmxbGridlbVO" type="{}jmssbmxbGridlbVOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jxds_zzs_ybnsr_jmssbmxbType", propOrder = {
    "jmssbmxbGridlbVO"
})
public class JxdsZzsYbnsrJmssbmxbType {

    protected List<JmssbmxbGridlbVOType> jmssbmxbGridlbVO;

    /**
     * Gets the value of the jmssbmxbGridlbVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jmssbmxbGridlbVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJmssbmxbGridlbVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JmssbmxbGridlbVOType }
     * 
     * 
     */
    public List<JmssbmxbGridlbVOType> getJmssbmxbGridlbVO() {
        if (jmssbmxbGridlbVO == null) {
            jmssbmxbGridlbVO = new ArrayList<JmssbmxbGridlbVOType>();
        }
        return this.jmssbmxbGridlbVO;
    }

}
