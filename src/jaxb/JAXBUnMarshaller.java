package jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


import people.generated.*;
import people.generated.People.Person;



public class JAXBUnMarshaller {
	public void unMarshall(File xmlDocument) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("people.generated");

			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(new File(
					"peoplecat.xsd"));
			unMarshaller.setSchema(schema);
			CustomValidationEventHandler validationEventHandler = new CustomValidationEventHandler();
			unMarshaller.setEventHandler(validationEventHandler);

			@SuppressWarnings("unchecked")
			People people = (People) unMarshaller
					.unmarshal(xmlDocument);
			List<people.generated.People.Person> personList = people.getPerson();
			
			
			for (int i=0; i < personList.size();i++) {
				int j = i+1;
				System.out.println("----------person #"+j+"----------");
				System.out.println("First name: " + personList.get(i).getFirstname());
				System.out.println("Last name: " + personList.get(i).getLastname());
				System.out.println("Birth date: " + personList.get(i).getBirthdate());
				System.out.println("Activity preference: ");
				System.out.println("Activity name: "+ personList.get(i).getActivitypreference().getName() + " Activity desc: "+ personList.get(i).getActivitypreference().getDescription()+" Activity start: "+ personList.get(i).getActivitypreference().getStartDate()+" Activity place: "+ personList.get(i).getActivitypreference().getPlace());
				System.out.println("");
			}
			
			
		} catch (JAXBException e) {
			System.out.println(e.toString());
		} catch (SAXException e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] argv) {
		File xmlDocument = new File("people.xml");
		JAXBUnMarshaller jaxbUnmarshaller = new JAXBUnMarshaller();

		jaxbUnmarshaller.unMarshall(xmlDocument);

	}

	class CustomValidationEventHandler implements ValidationEventHandler {
		public boolean handleEvent(ValidationEvent event) {
			if (event.getSeverity() == ValidationEvent.WARNING) {
				return true;
			}
			if ((event.getSeverity() == ValidationEvent.ERROR)
					|| (event.getSeverity() == ValidationEvent.FATAL_ERROR)) {

				System.out.println("Validation Error:" + event.getMessage());

				ValidationEventLocator locator = event.getLocator();
				System.out.println("at line number:" + locator.getLineNumber());
				System.out.println("Unmarshalling Terminated");
				return false;
			}
			return true;
		}

	}
}