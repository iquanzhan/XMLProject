package com.chengxiaoxiao.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * @ClassName: SAXParser
 * @description: 使用SAX进行XML解析，此解析方式为事件驱动，需要新建类继承DefaultHandler,并override其中的方法
 * @author: Cheng XiaoXiao
 * @Date: 2018-11-01
 */
public class SAXParser {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parse = factory.newSAXParser();

            parse.parse(new File("src/student.xml"), new MyHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class MyHandler extends DefaultHandler {

        /**
         * 文档开始
         */
        @Override
        public void startDocument() {
            System.out.println("Start Document");
        }

        /**
         * Element 开始，前两个参数默认为NULL
         *
         * @param uri        默认为NUll
         * @param localName  默认为NUll
         * @param qName      当前解析的元素名称
         * @param attributes 当前元素上的属性
         * @throws SAXException
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("student".equals(qName)) {
                String no = attributes.getValue("no");
                System.out.println("no:" + no);
            }
        }


        /**
         * 可以截取标记之间的文本内容
         *
         * @param ch     char[]数组
         * @param start  开始index
         * @param length 长度
         * @throws SAXException SAX解析异常
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);

            System.out.println(str);
        }

        /**
         * Document 结束
         *
         * @throws SAXException 解析异常
         */
        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }
    }
}

