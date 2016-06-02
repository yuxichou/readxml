package com.ytx.test;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * java读取xml文件
 * 条件：不知book下具体有多少个节点
 * @author tangxi
 *
 */
public class ReadXml {

	public static void main(String[] args) {
		//创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Document的parse方法读取xml文件
			Document document = db.parse("book.xml");
			//获取所有book节点集合
			NodeList nodeList = document.getElementsByTagName("book");
				//遍历book节点集合
				for(int i = 0;i< nodeList.getLength();i++){
					System.out.println("======第"+(i+1)+"本书，开始读取======");
					Node node = nodeList.item(i);
					//获取book节点的属性集合
					NamedNodeMap nnm = node.getAttributes();
					for(int j = 0; j< nnm.getLength(); j++){
						Node n = nnm.item(j);
						String s = n.getNodeName();
						String v = n.getNodeValue();
						System.out.println(s +" ："+ v);
						NodeList nl = node.getChildNodes();
						for(int k = 0;k < nl.getLength(); k++){
							Node no = nl.item(k);
							//按节点类型输出“ </name>这里类型<author>”和<author></author>节点类型不同
							if(no.getNodeType() == no.ELEMENT_NODE){
								System.out.println(no.getNodeName() + " ：" + no.getTextContent());
							}
						}
					}
					System.out.println("======第"+(i+1)+"本书，结束读取======");
					System.out.println();
				}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
