package by.spr.familyParsers.runners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.spr.familyParsers.bean.Human;
import by.spr.familyParsers.parsers.StAXMyParser;

public class StAXMainRunner {

	public static void main(String[] args) {
	
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream input = new FileInputStream("E:\\AS\\Practice\\ParserLesson\\src\\resources\\family.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			
			StAXMyParser parser = new StAXMyParser();

			@SuppressWarnings("static-access")
			List<Human> family = parser.process(reader);

			for (Human unit : family) {
				System.out.println(unit);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		

	}

}
