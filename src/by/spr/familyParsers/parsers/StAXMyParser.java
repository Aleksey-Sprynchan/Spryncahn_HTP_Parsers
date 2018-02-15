package by.spr.familyParsers.parsers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.spr.familyParsers.bean.*;
import by.spr.familyParsers.enam.StAXFamilyTagName;

public class StAXMyParser {


	@SuppressWarnings("incomplete-switch")
	public static List<Human> process(XMLStreamReader reader) throws XMLStreamException {

		List<Human> family = new ArrayList<Human>();
		Human human = null;
		StAXFamilyTagName elementName = null;
		Mother mother = null;
		Father father = null;
		Child child = null;

		while (reader.hasNext()) {

			int type = reader.next();

			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = StAXFamilyTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case FAMILY:
					String startDate = reader.getAttributeValue(null, "start-date");
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
				}
				break;

			case XMLStreamConstants.CHARACTERS:

				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}

				switch (elementName) {
				case NAME:
					human.setName(text);
					break;
				case SURNAME:
					human.setSurname(text);
					break;
				case AGE:
					human.setAge(Integer.parseInt(text));
					break;
				case MAIDEN_NAME:
					mother = (Mother) human;			
					mother.setMadenName(text);
					break;
				case SALARY:
					father = (Father) human;
					father.setSalary(Integer.parseInt(text));
					break;
				case GENDER:
					child = (Child) human;
					child.setGender(text);
					break;

				}
				break;
				
				
			case XMLStreamConstants.END_ELEMENT:
				elementName = StAXFamilyTagName.getElementTagName(reader.getLocalName());
				
				switch (elementName) {
				case MOTHER:
					family.add(mother);
					break;
				case FATHER:
					family.add(father);
					break;
				case CHILD:
					family.add(child);
					break;
				}
				break;
				
				

			}

		}

		return family;
	}

}
