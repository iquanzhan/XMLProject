package com.chengxiaoxiao.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName: DomParser
 * @description: 使用DOM方式解析xml文件（类似html中的Dom解析）
 * @author: Cheng XiaoXiao (🍊 ^_^ ^_^)
 * @Date: 2018-10-31
 */
public class DomParser {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/student.xml"));

            //根据标TagName获取节点
            NodeList students = document.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                //获取节点属性
                String no = student.getAttribute("no");

                NodeList childNodes = student.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node stuItem = childNodes.item(j);
                    //如果节点为Element类型
                    if (childNodes instanceof Element) {
                        //节点名称
                        String nodeName = stuItem.getNodeName();
                        //节点内容
                        String text = stuItem.getTextContent();

                        System.out.print("no:" + no + "," + nodeName + ":" + text + ",");
                    }
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



