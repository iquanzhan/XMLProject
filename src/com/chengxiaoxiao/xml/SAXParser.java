package com.chengxiaoxiao.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @ClassName: SAXParser
 * @description: 使用SAX进行XML解析，此解析方式为事件驱动，需要新建类继承DefaultHandler,并override其中的方法
 * @author: Cheng XiaoXiao
 * @Date: 2018-11-01
 */
public class SAXParser {

    public static void main(String[] args) {

    }


    class MyHandler extends DefaultHandler {

        /**
         * 文档开始
         * @throws SAXException
         */
        @Override
        public void startDocument() throws SAXException {
            System.out.println("文档开始处理了");
        }

        /**
         *
         * @param uri
         * @param localName
         * @param qName 当前解析的元素名称
         * @param attributes 当前元素上的属性
         * @throws SAXException
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        }
    }
}

