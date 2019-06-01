package org.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Event {

    private static ArrayList<Event> event = new ArrayList<>();

       public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document document = docBuilder.parse(Event.class.getClassLoader().getResourceAsStream("org/demo/test.xml"));
        document.getDocumentElement().normalize();
        NodeList eventElements = document.getElementsByTagName("event");

        for (int i = 0; i < eventElements.getLength(); i++) {
            event.add(getEvent(eventElements.item(i)));
        }
        for (Event emp : event) {
            System.out.println(emp);
        }
    }
    private static Event getEvent(Node node) {
        EventParameter emp = new EventParameter();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setEvent_id(getTagValue("event_id", element));
            emp.setEvent_date(getTagValue("event_date", element));
            emp.setPriority(Integer.parseInt(getTagValue("priority", element)));
            emp.setLog_level(getTagValue("log_level", element));
            emp.setSource(getTagValue("source", element));

        }

        return emp;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
