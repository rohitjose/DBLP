package org.test.simpleservlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SearchXMLFile {

	public static boolean compareCategory(String categoryList,
			String compareString) {
		/*
		 * Compares the category value sent in the parameter compareString to
		 * the pipe delimited list of categories in the string parameter
		 * categoryList. This function returns 'true' if the compareString value
		 * sent in the parameter is in the categoryList
		 */
		if (categoryList.contains("|" + compareString + "|"))
			return true;
		return false;
	}

	public static boolean matchNodes(HashMap<String, String> node,
			String match_key, String query, boolean exact_match) {
		/*
		 * Compares the query value sent in the parameter query to the value in
		 * the HashMap node that is extracted from the source XML file. The
		 * function checks for an exact match based on the parameter value -
		 * exact_match
		 */
		String value = node.get(match_key).trim();
		query = query.trim();
		if (value == null)
			return false;
		if (exact_match)
			return value.equals(query);
		return value.contains(query);
	}

	public static ArrayList<HashMap<String, String>> getnodes(String category,
			String title_query, String file_name, int skip_count,
			int retrieve_count) {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		HashMap<String, String> article_values = new HashMap<String, String>();
		ArrayList<HashMap<String, String>> article_list = new ArrayList<HashMap<String, String>>();

		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		StringWriter title_tag = new StringWriter();
		XMLEventWriter xmlWriter = null;

		try {
			XMLEventReader xmlEventReader = xmlInputFactory
					.createXMLEventReader(new FileInputStream(file_name));
			boolean add_elements = false;
			boolean title_tag_flag = false;
			String node_name = new String();

			while (xmlEventReader.hasNext()) {
				// Get the next event in the XML file
				XMLEvent xmlEvent = xmlEventReader.nextEvent();

				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					node_name = startElement.getName().getLocalPart();

					if (compareCategory(category, node_name))
						add_elements = true;

					if (node_name.equals("title")) {
						xmlWriter = xmlOutputFactory
								.createXMLEventWriter(title_tag);
						title_tag_flag = true;
					}

				} else if (xmlEvent.isCharacters()) {
					String value = xmlEvent.asCharacters().getData().trim();
					if (!value.isEmpty() && !title_tag_flag)
						article_values.put(node_name, xmlEvent.asCharacters()
								.getData());
					else if (!value.isEmpty() && title_tag_flag) {
						xmlWriter.add(xmlEvent);
					}
				} else if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					node_name = endElement.getName().getLocalPart();

					if (node_name.equals("title")) {
						xmlWriter.close();
						String title = title_tag.toString().replaceAll(
								"\\<[^>]*>", "");
						article_values.put("title", title);
						title_tag = new StringWriter();
						title_tag_flag = false;
					}

					if (compareCategory(category, node_name)) {
						article_values.put("type",node_name);
						if (matchNodes(article_values, "title", title_query,
								false)) {
							if (skip_count == 0) {
								article_list.add(article_values);
							} else {
								skip_count--;
							}
						}
						article_values = new HashMap<String, String>();
						add_elements = false;
					}
				}

				if (article_list.size() >= retrieve_count) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article_list;
	}

	public static void main(String[] args) {
		String category = "|article|www|";
		String title_query = "Parser";
		String file_name = "/home/rohit/workspace/SImpleServletProject/src/org/test/simpleservlet/dblp.xml";
		int skip_count = 50;
		int retrieve_count = 1;

		ArrayList<HashMap<String, String>> article_list = new ArrayList<HashMap<String, String>>();

		article_list = getnodes(category, title_query, file_name, skip_count,
				retrieve_count);

		if (article_list.size() > 0) {
			for (HashMap<String, String> article : article_list) {
				for (String key : article.keySet()) {
					System.out.println(key + " : " + article.get(key));
				}
			}
		} else {
			System.out.println("No Query match!!");
		}
	}
}
