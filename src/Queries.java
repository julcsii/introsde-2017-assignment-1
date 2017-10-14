import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import org.xml.sax.SAXException;


import xml.model.Person;

/*
 * 
 Use XPath to implement methods like getActivityDescription and getActivityPlace. Use the person ID as parameter of the getters.
 Make a function that prints all people in the list with details.
 Make a function that accepts the person id as parameter and prints the ActivityPreference of the person with that id.
 Make a function which accepts a date and an operator (=, > , <) as parameters and prints people which preferred activity start_date fulfill that condition \
 (i.e., startdate>2017-13-10, startdate=2017-13-10, etc.).
 */
public class Queries {
    static Document doc;
    static XPath xpath;
   


    public static void loadXML() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse("people.xml");

        //creating xpath object
        getXPathObj();
    }

    public static XPath getXPathObj() {

        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }
    
	public String printAllPeole() throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getTextContent();
	}
    
	public String getFirstname(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(1).getTextContent();
	}

	public String getLastname(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(3).getTextContent();
	}

	public String getBirthdate(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(5).getTextContent();
	}
	
	public String getActivity(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getTextContent();
	}
   
	public String getActivityDescription(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getChildNodes().item(1).getTextContent();
		
	}
	
	public String getActivityId(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getChildNodes().item(3).getTextContent();
	}

	public String getActivityName(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getChildNodes().item(5).getTextContent();
	}
	
	public String getActivityPlace(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getChildNodes().item(7).getTextContent();
	}
	
	public String getActivityStartDate(String personId) throws XPathExpressionException {
		XPathExpression expr = xpath.compile("/people/person['" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getChildNodes().item(7).getChildNodes().item(9).getTextContent();
	}
	
	
	public String getSpecPeople(Date date, char operator){
		return "to be solved";
	}
	

	
    public static void main(String[] args) throws ParserConfigurationException, SAXException,
    IOException, XPathExpressionException {

		loadXML();
		Queries q = new Queries();
		
		//print all people
		System.out.println(q.printAllPeole());
		
		//print different attributes of person #5
		System.out.println("///////////////Person #5////////////////");
		System.out.println(q.getFirstname("5"));
		System.out.println(q.getLastname("5"));
		System.out.println(q.getBirthdate("5"));
		System.out.println(q.getActivity("5"));
		System.out.println("///////////////Activity details of Person #5////////////////");
		System.out.println(q.getActivityDescription("5"));
		System.out.println(q.getActivityId("5"));
		System.out.println(q.getActivityName("5"));
		System.out.println(q.getActivityPlace("5"));
		System.out.println(q.getActivityStartDate("5"));
		
		//return people who started sports before 2017-10-13
		System.out.println(q.getSpecPeople(new Date(), '>'));
		
	}
	
	
}
