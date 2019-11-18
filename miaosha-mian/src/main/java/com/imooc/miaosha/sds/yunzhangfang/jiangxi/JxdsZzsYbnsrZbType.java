
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jxds_zzs_ybnsr_zbType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jxds_zzs_ybnsr_zbType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zbGridlbVO" type="{}zbGridlbVOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jxds_zzs_ybnsr_zbType", propOrder = {
    "zbGridlbVO"
})
public class JxdsZzsYbnsrZbType {

    protected List<ZbGridlbVOType> zbGridlbVO;

    /**
     * Gets the value of the zbGridlbVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zbGridlbVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZbGridlbVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZbGridlbVOType }
     * 
     * 
     */
    public List<ZbGridlbVOType> getZbGridlbVO() {
        if (zbGridlbVO == null) {
            zbGridlbVO = new ArrayList<ZbGridlbVOType>();
        }
        return this.zbGridlbVO;
    }

}
