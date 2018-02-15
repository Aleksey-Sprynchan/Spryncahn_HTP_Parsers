package by.spr.familyParsers.parsers;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.spr.familyParsers.bean.*;


public class DOMMyParser {

	public static List<Human> process(Document document) {

		Element root = document.getDocumentElement();
		List<Human> family = new ArrayList<Human>();

		// NodeList motherNodes = root.getElementsByTagName("mother");
		// Mother human = null;
		// for(int i = 0; i < motherNodes.getLength(); i++) {
		// human = new Mother();
		// Element motherElement = (Element) motherNodes.item(i);
		// human.setName(getSingleChild(motherElement, "name").getTextContent().trim());
		// human.setSurname(getSingleChild(motherElement,
		// "surname").getTextContent().trim());
		// human.setAge(Integer.parseInt(getSingleChild(motherElement,
		// "age").getTextContent().trim()));
		// human.setMadenName(getSingleChild(motherElement,
		// "maiden-name").getTextContent().trim());
		//
		// family.add(human);
		//
		// }
		//
		// NodeList fatherNodes = root.getElementsByTagName("father");
		// Father human1 = null;
		// for(int i = 0; i < fatherNodes.getLength(); i++) {
		// human1 = new Father();
		// Element fatherElement = (Element) fatherNodes.item(i);
		// human1.setName(getSingleChild(fatherElement,
		// "name").getTextContent().trim());
		// human1.setSurname(getSingleChild(fatherElement,
		// "surname").getTextContent().trim());
		// human1.setAge(Integer.parseInt(getSingleChild(fatherElement,
		// "age").getTextContent().trim()));
		// human1.setSalary(Integer.parseInt(getSingleChild(fatherElement,
		// "salary").getTextContent().trim()));
		//
		// family.add(human1);
		//
		// }
		//
		// NodeList childNodes = root.getElementsByTagName("child");
		// Child child = null;
		// for(int i = 0; i < childNodes.getLength(); i++) {
		// child = new Child();
		// Element childElement = (Element) childNodes.item(i);
		// child.setName(getSingleChild(childElement, "name").getTextContent().trim());
		// child.setSurname(getSingleChild(childElement,
		// "surname").getTextContent().trim());
		// child.setAge(Integer.parseInt(getSingleChild(childElement,
		// "age").getTextContent().trim()));
		// child.setGender(getSingleChild(childElement,
		// "gender").getTextContent().trim());
		//
		// family.add(child);
		//
		// }


		Human human = new Mother();
		Element m = setCommonFileds("mother", root, human, 1);
		Mother mother = (Mother) human;
		mother.setMadenName(getSingleChild(m, "maiden-name").getTextContent().trim());
		family.add(mother);

		human = new Father();
		Element f = setCommonFileds("father", root, human, 1);
		Father father = (Father) human;
		father.setSalary(Integer.parseInt(getSingleChild(f, "salary").getTextContent().trim()));
		family.add(father);

		NodeList childNodes = root.getElementsByTagName("child");
		for (int i = 1; i <= childNodes.getLength(); i++) {
			human = new Child();
			Element c = setCommonFileds("child", root, human, i);
			Child child = (Child) human;
			child.setGender(getSingleChild(c, "gender").getTextContent().trim());
			family.add(child);
		}

		return family;

	}

	public static String getStartDate(Document document) {
		Element root = document.getDocumentElement();
		String startDate = root.getAttribute("start-date");
		return startDate;

	}

	private static Element getSingleChild(Element element, String chilName) {
		NodeList nlist = element.getElementsByTagName(chilName);
		Element child = (Element) nlist.item(0);
		return child;
	}

	private static Element setCommonFileds(String tagName, Element root, Human human, int count) {

		NodeList tagNameNodes = root.getElementsByTagName(tagName);

		Element tagNameElement = (Element) tagNameNodes.item(count - 1);
		human.setName(getSingleChild(tagNameElement, "name").getTextContent().trim());
		human.setSurname(getSingleChild(tagNameElement, "surname").getTextContent().trim());
		human.setAge(Integer.parseInt(getSingleChild(tagNameElement, "age").getTextContent().trim()));

		return tagNameElement;

	}

}
