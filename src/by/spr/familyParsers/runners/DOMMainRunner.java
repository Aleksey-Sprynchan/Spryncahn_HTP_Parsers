package by.spr.familyParsers.runners;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.spr.familyParsers.bean.*;
import by.spr.familyParsers.parsers.DOMMyParser;

//import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class DOMMainRunner {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse("E:\\AS\\Practice\\ParserLesson\\src\\resources\\family.xml");

		// DOMParser parser = new DOMParser();
		// try {
		// parser.parse("E:\\AS\\Practice\\ParserLesson\\src\\resources\\family.xml");
		// } catch (SAXException | IOException e) {
		// e.printStackTrace();
		// }
		//
		// Document document = parser.getDocument();

		String startDate = DOMMyParser.getStartDate(document);
		System.out.println("Family start date is " + startDate);

		List<Human> family = DOMMyParser.process(document);
		for (Human unit : family) {
			System.out.println(unit);
		}

	}
}
