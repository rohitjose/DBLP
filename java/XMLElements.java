package org.test.simpleservlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLElements {

	public static boolean checknode(String node) {

		ArrayList<String> nodelist = new ArrayList<String>();
		nodelist.add("article");
		nodelist.add("inproceedings");
		nodelist.add("proceedings");
		nodelist.add("book");
		nodelist.add("incollection");
		nodelist.add("phdthesis");
		nodelist.add("mastersthesis");
		nodelist.add("www");

		if (nodelist.contains(node)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

		try {
			XMLEventReader xmlEventReader = xmlInputFactory
					.createXMLEventReader(new FileInputStream(
							"/home/rohit/workspace/SImpleServletProject/src/org/test/simpleservlet/dblp.xml"));
			long count = 0;
			HashMap<String, HashSet> nodes = new HashMap<String, HashSet>();
			String currentRoot = new String();

			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				count++;
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					String node_name = startElement.getName().getLocalPart();
					HashSet<String> node_list = new HashSet<String>();
					if (currentRoot.isEmpty()) {
						if (!node_name.equals("dblp") && !node_name.equals(""))
							currentRoot = node_name;
					}

					if (nodes.containsKey(currentRoot)) {
						node_list = nodes.get(currentRoot);
					}

					if (checknode(node_name) && !node_name.equals(currentRoot)) {
						currentRoot = node_name;
						node_list = new HashSet<String>();
					} else if (!node_name.equals("dblp")&&!node_name.equals(currentRoot)) {
						node_list.add(node_name);
					}
					if (!currentRoot.isEmpty())
						nodes.put(currentRoot, node_list);
				}
				if (xmlEvent.isEndElement()) {

				}
			}
			for (String key : nodes.keySet()) {
				System.out.println("Key Value: " + key);
				HashSet<String> attribute_values = (HashSet<String>) nodes
						.get(key);
				int i = 0;
				for (String value : attribute_values) {
					System.out.println("Element " + i + ": " + value);
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
