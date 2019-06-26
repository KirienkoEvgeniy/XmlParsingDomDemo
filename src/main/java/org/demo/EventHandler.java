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
import java.util.List;

public class EventHandler {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();

    public EventHandler() throws ParserConfigurationException {
    }

    public List<Event> eventParser() throws IOException, SAXException {
        Document document = docBuilder.parse(Event.class.getClassLoader().getResourceAsStream("org/demo/test.xml"));
        document.getDocumentElement().normalize();
        NodeList eventElements = document.getElementsByTagName("event");
        ArrayList<Event> eventList = new ArrayList<>();
        for (int i = 0; i < eventElements.getLength(); i++) {
            eventList.add(getEvent(eventElements.item(i)));

        }

        return eventList;
    }

    private static Event getEvent(Node node) {
        Event emp = new Event();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elementEvent = (Element) node;
            emp.setEvent_id(getTagValue("event_id", elementEvent));
            emp.setEvent_date(getTagValue("event_date", elementEvent));
            Element event_parameters = (Element) elementEvent.getElementsByTagName("event_parameters").item(0);
            String priority = getTagValue("priority", event_parameters);
            String log_level = getTagValue("log_level", event_parameters);
            String source = getTagValue("source", event_parameters);
            emp.getEventParameter().add(new EventParameter(Integer.parseInt(priority), log_level, source));
        }
        return emp;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        EventHandler eventHandler = new EventHandler();
        List<Event> events = eventHandler.eventParser();
        for (Event emp : events) {
            System.out.println(emp);
        }
    }
}
