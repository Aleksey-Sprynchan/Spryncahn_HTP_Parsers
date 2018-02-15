package by.spr.familyParsers.parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.spr.familyParsers.bean.Child;
import by.spr.familyParsers.bean.Father;
import by.spr.familyParsers.bean.Human;
import by.spr.familyParsers.bean.Mother;
import by.spr.familyParsers.enam.SAXFamilyTagName;

public class SAXMyParser extends DefaultHandler {

	private List<Human> family = new ArrayList<Human>();
	private StringBuilder text;
	private Human human = null;
	private Mother mother = null;
	private Father father = null;
	private List<Human> children = new ArrayList<Human>();
	private Child child = null;

	public List<Human> getFamily() {
		return family;
	}

	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Parsing started.");
	}

	@Override
	public void endDocument() throws SAXException {
		//System.out.println("Parsing ended.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		text = new StringBuilder();
		SAXFamilyTagName tag = SAXFamilyTagName.valueOf(localName.toUpperCase().replace('-', '_'));

		switch (tag) {
		case FAMILY:
			String startDate = attributes.getValue(0);
			System.out.println("Family start date is " + startDate);
			break;
		case MOTHER:
			human = new Mother();
			break;
		case FATHER:
			human = new Father();
			break;
		case CHILD:
			human = new Child();
			break;
		default:
			break;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		SAXFamilyTagName tag = SAXFamilyTagName.valueOf(localName.toUpperCase().replace('-', '_'));

		switch (tag) {
		case NAME:
			human.setName(text.toString().trim());
			//System.out.print(human.getName());
			break;
		case SURNAME:
			human.setSurname(text.toString().trim());
			//System.out.println(human.getSurname());
			break;
		case AGE:
			human.setAge(Integer.parseInt(text.toString().trim()));
			break;
		case MAIDEN_NAME:
			mother = (Mother) human;			
			mother.setMadenName(text.toString().trim());
			family.add(mother);
			break;
		case SALARY:
			father = (Father) human;
			father.setSalary(Integer.parseInt(text.toString().trim()));
			family.add(father);
			break;
		case GENDER:
			child = (Child) human;
			child.setGender(text.toString().trim());
			children.add(child);
			break;
		case CHILDREN:
			family.addAll(children);
		default:
			break;

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

}
