
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jxds_zzs_ybnsr_fb3Type complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jxds_zzs_ybnsr_fb3Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fb3GridlbVO" type="{}fb3GridlbVOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jxds_zzs_ybnsr_fb3Type", propOrder = {
    "fb3GridlbVO"
})
public class JxdsZzsYbnsrFb3Type {

    protected List<Fb3GridlbVOType> fb3GridlbVO;

    /**
     * Gets the value of the fb3GridlbVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fb3GridlbVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFb3GridlbVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fb3GridlbVOType }
     * 
     * 
     */
    public List<Fb3GridlbVOType> getFb3GridlbVO() {
        if (fb3GridlbVO == null) {
            fb3GridlbVO = new ArrayList<Fb3GridlbVOType>();
        }
        return this.fb3GridlbVO;
    }

}
