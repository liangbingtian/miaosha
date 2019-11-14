
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jxds_zzs_ybnsr_fb2Type complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jxds_zzs_ybnsr_fb2Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fb2GridlbVO" type="{}fb2GridlbVOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jxds_zzs_ybnsr_fb2Type", propOrder = {
    "fb2GridlbVO"
})
public class JxdsZzsYbnsrFb2Type {

    protected List<Fb2GridlbVOType> fb2GridlbVO;

    /**
     * Gets the value of the fb2GridlbVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fb2GridlbVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFb2GridlbVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fb2GridlbVOType }
     * 
     * 
     */
    public List<Fb2GridlbVOType> getFb2GridlbVO() {
        if (fb2GridlbVO == null) {
            fb2GridlbVO = new ArrayList<Fb2GridlbVOType>();
        }
        return this.fb2GridlbVO;
    }

}
