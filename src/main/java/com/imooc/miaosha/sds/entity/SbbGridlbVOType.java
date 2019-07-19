
package com.imooc.miaosha.sds.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sbbGridlbVOType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sbbGridlbVOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ewbhxh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqsfsyzzsxgmnsrjzzcjmxzdm09049901" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqsfsyzzsxgmnsryhzc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zzsxgmnsrxsjzbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gxhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jgclhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsgckcsjhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jzazgccbhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cczlhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaysfywfzwthbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaysfywfzwthbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaysfywfzwthbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaysfywfzwthbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hwyshtaysfywfzwthbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbghtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccbxhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshthdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jshtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjhdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cqzysjbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbhdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjmxzdmhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjzzjdzbbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjzzjdzbbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjzzjdzbbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjzzjdzbbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbjzzjdzbbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdhdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zbzzesszbzbgjdbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzaszsjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzjmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqzzsxgmnsrjzehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzyspz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzhdzshdyjje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qlxkzzbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jmsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bqybtsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dlrgzsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jbrsfzhmsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhthdzshdyj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhthdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkhtbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbhdzshdyj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yyzbqtzbsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hjbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbsyslhdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbjsjehjs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqjmsejmxzdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbhdzshdyj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqzzsxgmnsrjzejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqybtsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqynsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqyjsehdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbbqjmsejmse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zjzbhdzshdbl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sbbGridlbVOType", propOrder = {
    "ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc"
})
public class SbbGridlbVOType {

    @XmlElementRefs({
        @XmlElementRef(name = "cczlhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzhdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdhdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjzzjdzbbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqsfsyzzsxgmnsrjzzcjmxzdm09049901", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjzzjdzbbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjmxzdmhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjhdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjzzjdzbbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjzzjdzbbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbhdzshdyj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zzsxgmnsrxsjzbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaysfywfzwthbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaysfywfzwthbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaysfywfzwthbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaysfywfzwthbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdhdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbhdzshdyj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zbzzesszbzbgjdaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ewbhxh", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhthdzshdyj", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtaysfywfzwthbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jbrsfzhmsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhthdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bqsfsyzzsxgmnsryhzc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqjmsejmxzdm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbghtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cczlhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "dlrgzsyslhdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jgclhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hwyshthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhtjmsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hjbqynsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbhdzshdyjje", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqybtsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjaszsjsjehjs", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ccbxhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbyspz", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jsgckcsjhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jkhtbqybtsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jzazgccbhtbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "jshtbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbqtzbbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbjzzjdzbbqjmsejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gxhthdzshdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zjzbbqyjsehdbl", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "qlxkzzbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cqzysjbqzzsxgmnsrjzejmse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "yyzbbqzzsxgmnsrjzehdbl", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc;

    /**
     * Gets the value of the ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEwbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc().add(newItem);
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
    public List<JAXBElement<String>> getEwbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc() {
        if (ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc == null) {
            ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc = new ArrayList<JAXBElement<String>>();
        }
        return this.ewbhxhOrBqsfsyzzsxgmnsrjzzcjmxzdm09049901OrBqsfsyzzsxgmnsryhzc;
    }

}
