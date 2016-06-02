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
 * java��ȡxml�ļ�
 * ��������֪book�¾����ж��ٸ��ڵ�
 * @author tangxi
 *
 */
public class ReadXml {

	public static void main(String[] args) {
		//����DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//����DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Document��parse������ȡxml�ļ�
			Document document = db.parse("book.xml");
			//��ȡ����book�ڵ㼯��
			NodeList nodeList = document.getElementsByTagName("book");
				//����book�ڵ㼯��
				for(int i = 0;i< nodeList.getLength();i++){
					System.out.println("======��"+(i+1)+"���飬��ʼ��ȡ======");
					Node node = nodeList.item(i);
					//��ȡbook�ڵ�����Լ���
					NamedNodeMap nnm = node.getAttributes();
					for(int j = 0; j< nnm.getLength(); j++){
						Node n = nnm.item(j);
						String s = n.getNodeName();
						String v = n.getNodeValue();
						System.out.println(s +" ��"+ v);
						NodeList nl = node.getChildNodes();
						for(int k = 0;k < nl.getLength(); k++){
							Node no = nl.item(k);
							//���ڵ���������� </name>��������<author>����<author></author>�ڵ����Ͳ�ͬ
							if(no.getNodeType() == no.ELEMENT_NODE){
								System.out.println(no.getNodeName() + " ��" + no.getTextContent());
							}
						}
					}
					System.out.println("======��"+(i+1)+"���飬������ȡ======");
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
