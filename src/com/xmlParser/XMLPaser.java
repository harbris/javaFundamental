package com.xmlParser;

import java.util.Arrays;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLPaser {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		XMLPaser a = new XMLPaser();
		a.withSAXPaser();

	}
	
	public void withSAXPaser() throws Exception{
		ParseSAX handler = new ParseSAX();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		saxParser.parse("D:/test.xml", handler);
		System.out.println(handler.getData());
		
	}
	
	public void withDOMPaser() throws Exception{
		ParseDOM pd = new ParseDOM();
		pd.parseDOM("D:/test.xml");
		System.out.println(pd.getData());
		
	}
	
	
}
