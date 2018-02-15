package by.spr.familyParsers.runners;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.spr.familyParsers.bean.Human;
import by.spr.familyParsers.parsers.SAXMyParser;

public class SaxMainRunner {

	public static void main(String[] args) throws SAXException, IOException {

		XMLReader reader = XMLReaderFactory.createXMLReader();
		SAXMyParser handler = new SAXMyParser();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("E:\\AS\\Practice\\ParserLesson\\src\\resources\\family.xml"));

		List<Human> family = handler.getFamily();

		for (Human unit : family) {
			System.out.println(unit);
		}

	}

}
