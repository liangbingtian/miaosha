
package com.imooc.miaosha.sds.yunzhangfang.jiangxi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fb1GridlbVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="fb1GridlbVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ewbhxh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwkjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwkjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwkjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldhwjjgxlxplwkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzcwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzcnsjcdzxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzchjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzcnsjcdzxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzckchxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmsldfwbdchwxzcwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslnsjcdzxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslnsjcdzxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkchxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslhjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqbzsxmslkchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjthwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjthwjjgxlxplwhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzchjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzckchxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yybjsffjsqzjzjtxmjzjtfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslkjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslkjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslkjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzslwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwkjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwkjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwkjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldhwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzchjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzcwkjfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzcwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckjqtfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqbzsxmzsldfwbdchwxzckchxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjthwjjgxlxplwhjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjthwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzckchxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtshwjjgxlxplwkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtshwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtshwjjgxlxplwwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzcwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzckjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smdtsfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smshwjjgxlxplwkjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smshwjjgxlxplwkjskzzszyfpxxynse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smshwjjgxlxplwkjskzzszyfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smshwjjgxlxplwwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smshwjjgxlxplwhjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzckchhsmsxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzchjjshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzcysfwkcxmbqsjkcjejshj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzckjqtfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzchjxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsfwbdchwxzcwkjfpxse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fb1GridlbVOType", propOrder = {
    "ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse"
})
public class Fb1GridlbVOType {

    @XmlElementRefs({
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjthwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzchjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwkjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwkjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzckchxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwkjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzchjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzckchxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smshwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslkjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smshwjjgxlxplwwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslnsjcdzxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzcwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjthwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjthwjjgxlxplwhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ewbhxh", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslkjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwkjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslnsjcdzxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzcnsjcdzxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzckjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjthwjjgxlxplwhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzcwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzckjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smshwjjgxlxplwkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkchxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smshwjjgxlxplwkjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwkjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smshwjjgxlxplwkjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkjqtfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzchjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckchxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzcwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smsfwbdchwxzchjjshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzcysfwkcxmbqsjkcjejshj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtshwjjgxlxplwwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslhjxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzckjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqzjzjtxmjzjtfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwkjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldhwjjgxlxplwwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtshwjjgxlxplwhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslkjskzzszyfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzckchxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtsfwbdchwxzcwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzsldfwbdchwxzcwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslkjskzzszyfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "smdtshwjjgxlxplwkjqtfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ejyjsffjsqbzsxmzslhjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzcwkjfpxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqzjzjtxmjzjtfwbdchwxzckchhsmsxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzchjxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmsldfwbdchwxzcnsjcdzxxynse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslwkjfpxse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yybjsffjsqbzsxmslhjjshj", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse;

    /**
     * Gets the value of the ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEwbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse().add(newItem);
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
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getEwbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse() {
        if (ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse == null) {
            ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse = new ArrayList<JAXBElement<String>>();
        }
        return this.ewbhxhOrYybjsffjsqbzsxmsldhwjjgxlxplwwkjfpxxynseOrYybjsffjsqbzsxmsldhwjjgxlxplwnsjcdzxxynse;
    }

}
