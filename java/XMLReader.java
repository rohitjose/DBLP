/**
 * 
 */
package org.test.simpleservlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author rohit
 *
 */
public class XMLReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

		try {
			XMLEventReader xmlEventReader = xmlInputFactory
					.createXMLEventReader(new FileInputStream(
							"/home/rohit/workspace/SImpleServletProject/src/org/test/simpleservlet/dblp.xml"));
			long count = 0;
			HashMap<String, HashSet> nodes = new HashMap<String, HashSet>();
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				count++;
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					String node_name = startElement.getName().getLocalPart();
					Iterator attrs = startElement.getAttributes();
					HashSet<String> attribute_list = new HashSet<String>();
					int contains_flag = 0;
					if (nodes.containsKey(node_name)) {
						attribute_list = (HashSet<String>) nodes.get(node_name);
						contains_flag = 1;
					}
					while (attrs.hasNext()) {
						Attribute attr = (Attribute) attrs.next();
						String attribute_name = attr.getName().getLocalPart();
						if (!attribute_list.contains(attribute_name)) {
							attribute_list.add(attr.getName().getLocalPart());
						}
					}
					nodes.put(node_name, attribute_list);
				}
			}
			for (String key : nodes.keySet()) {
				System.out.println("Key Value: " + key);
				HashSet<String> attribute_values = (HashSet<String>) nodes
						.get(key);
				int i = 0;
				for (String value : attribute_values) {
					System.out.println("Attribute " + i + ": " + value);
					i++;
				}
			}
			System.out.println("Total nodes covered: " + count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
