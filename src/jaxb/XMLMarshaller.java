package jaxb;

import java.io.File;

import java.util.Date;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import dao.PeopleStore;
import dao.Setup;
import xml.model.Activity;
import xml.model.Person;

public class XMLMarshaller {
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) throws Exception {
		
		Setup.initializeDB(people);
		
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        m.marshal(people,new File("people.xml")); // marshalling into a file
        m.marshal(people, System.out);			  // marshalling into the system default output
    }
}
