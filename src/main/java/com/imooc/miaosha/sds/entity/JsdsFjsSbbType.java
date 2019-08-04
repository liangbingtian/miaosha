
package com.imooc.miaosha.sds.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jsds_fjs_sbbType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jsds_fjs_sbbType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sbbGridlbVO" type="{}sbbGridlbVOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jsds_fjs_sbbType", propOrder = {
    "sbbGridlbVO"
})
public class JsdsFjsSbbType {

    protected List<SbbGridlbVOType> sbbGridlbVO;

    /**
     * Gets the value of the sbbGridlbVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sbbGridlbVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSbbGridlbVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SbbGridlbVOType }
     * 
     * 
     */
    public List<SbbGridlbVOType> getSbbGridlbVO() {
        if (sbbGridlbVO == null) {
            sbbGridlbVO = new ArrayList<SbbGridlbVOType>();
        }
        return this.sbbGridlbVO;
    }

}
