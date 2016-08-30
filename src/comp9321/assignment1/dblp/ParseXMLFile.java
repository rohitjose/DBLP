package comp9321.assignment1.dblp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ParseXMLFile {

	private static Random random;

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

	public static boolean getRandomBoolean() {
		return random.nextBoolean();
	}

	public static boolean matchNodes(HashMap<String, String> node,
			String match_key, String query, boolean exact_match) {
		/*
		 * Compares the query value sent in the parameter query to the value in
		 * the HashMap node that is extracted from the source XML file. The
		 * function checks for an exact match based on the parameter value -
		 * exact_match
		 */
		String value = new String();
		if (node.containsKey(match_key))
			value = node.get(match_key).trim();
		query = query.trim();
		if (value == null)
			return false;
		if (exact_match)
			return value.equals(query);
		return value.contains(query);
	}

	public static ArrayList<HashMap<String, String>> getRandomDocuments(
			int retrieve_count) throws IOException {

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		HashMap<String, String> article_values = new HashMap<String, String>();
		ArrayList<HashMap<String, String>> article_list = new ArrayList<HashMap<String, String>>();

		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		StringWriter title_tag = new StringWriter();
		XMLEventWriter xmlWriter = null;

		PropertyValues property = new PropertyValues();
		String file_name = property.getPropValues("file_name");
		String category = property.getPropValues("document_types");

		random = new Random();

		try {
			XMLEventReader xmlEventReader = xmlInputFactory
					.createXMLEventReader(new FileInputStream(file_name));
			@SuppressWarnings("unused")
			boolean add_elements = false;
			boolean title_tag_flag = false;
			String node_name = new String();

			while (xmlEventReader.hasNext()) {
				// Get the next event in the XML file
				XMLEvent xmlEvent = xmlEventReader.nextEvent();

				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					node_name = startElement.getName().getLocalPart();
					Iterator<?> attrs = startElement.getAttributes();

					while (attrs.hasNext()) {
						Attribute attr = (Attribute) attrs.next();
						String attribute_value = attr.getValue();
						String attribute_name = attr.getName().getLocalPart();
						if (!attribute_value.isEmpty())
							article_values.put(
									node_name + "_" + attribute_name,
									attribute_value);
					}

					if (compareCategory(category, node_name))
						add_elements = true;

					if (node_name.equals("title")) {
						xmlWriter = xmlOutputFactory
								.createXMLEventWriter(title_tag);
						title_tag_flag = true;
					}

				} else if (xmlEvent.isCharacters()) {
					String value = xmlEvent.asCharacters().getData().trim();
					if (!value.isEmpty() && !title_tag_flag) {
						if (article_values.containsKey(node_name))
							value = article_values.get(node_name) + ", " + value;
						article_values.put(node_name, value);
					} else if (!value.isEmpty() && title_tag_flag) {
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
						article_values.put("type", node_name);
						if (getRandomBoolean())
							article_list.add(article_values);
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
			@SuppressWarnings("unused")
			boolean add_elements = false;
			boolean title_tag_flag = false;
			String node_name = new String();

			while (xmlEventReader.hasNext()) {
				// Get the next event in the XML file
				XMLEvent xmlEvent = xmlEventReader.nextEvent();

				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					node_name = startElement.getName().getLocalPart();
					Iterator<?> attrs = startElement.getAttributes();

					while (attrs.hasNext()) {
						Attribute attr = (Attribute) attrs.next();
						String attribute_value = attr.getValue();
						String attribute_name = attr.getName().getLocalPart();
						if (!attribute_value.isEmpty())
							article_values.put(
									node_name + "_" + attribute_name,
									attribute_value);
					}

					if (compareCategory(category, node_name))
						add_elements = true;

					if (node_name.equals("title")) {
						xmlWriter = xmlOutputFactory
								.createXMLEventWriter(title_tag);
						title_tag_flag = true;
					}

				} else if (xmlEvent.isCharacters()) {
					String value = xmlEvent.asCharacters().getData().trim();
					if (!value.isEmpty() && !title_tag_flag) {
						if (article_values.containsKey(node_name))
							value = article_values.get(node_name) + ", "
									+ value;
						article_values.put(node_name, value);
					} else if (!value.isEmpty() && title_tag_flag) {
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
						article_values.put("type", node_name);
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
		String title_query = "Evolutionary Systems: A Language Generating Device Inspired by Evolving Communities of Cells";
		String file_name = "/home/rohit/workspace/SImpleServletProject/src/org/test/simpleservlet/dblp.xml";
		int skip_count = 0;
		int retrieve_count = 50;

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