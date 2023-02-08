package com.powernode.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/8 17:00
 * @Version 1.0.1
 */
public class ParseXMLByDom4jTest {
    @Test
    public void testParseConfigXML() throws DocumentException {
        // 创建saxReader
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml"));
        // System.out.println(document);
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        // xpath是做标签路径匹配的 让我们快速定位xml中的元素
        String xpath="/configuration/environments";
        Element element = (Element)document.selectSingleNode(xpath);
        String aDefault = element.attributeValue("default");
        System.out.println(aDefault);
        List<Element> environment = element.elements("environment");
        environment.forEach(element1 -> System.out.println(element1.attributeValue("id")));
        System.out.println("________________________");

        String xpath2="/configuration/environments/environment[@id='"+aDefault+"']";
        System.out.println(xpath2);
        Element element2 = (Element)document.selectSingleNode(xpath2);
        String id = element2.attributeValue("id");
        System.out.println(id);

        Element transactionManager = element2.element("transactionManager");
        String type = transactionManager.attributeValue("type");
        System.out.println(type);

        Element dataSource = element2.element("dataSource");
        System.out.println(dataSource.attributeValue("type"));

        List<Element> elements = dataSource.elements();
        elements.forEach(element1 -> {
            String name = element1.attributeValue("name");
            String value = element1.attributeValue("value");
            System.out.println(name+" "+value);
        });


        // 任意位置开始，获取所有某个标签
        String xpath3="//mapper";
        List<Node> nodes = document.selectNodes(xpath3);
        nodes.forEach(node -> {
            Element element1=(Element) node;
            String resource = element1.attributeValue("resource");
            System.out.println(resource);
        });

    }
}
