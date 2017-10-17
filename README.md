# introsde-2017-assignment-1
University of Trento

Introduction of Service Design Engineering 

2017 Fall

#### Name: Julia Hermann
#### Email: julia.hermann@studenti.unitn.it

#### Task
Reading/Writing objects to and from XML and JSON using Java technologies, JAXB and Jackson, xpath, json, xml/xsd.

#### Code execution
Clone this repo to a folder and run the compile task from build.xml. This should resolve all necessary dependencies. Then run execute.evaluation from buil.xml to see output on console.

#### Notes

1. Created Activity.java, Person.java (xml.model) and Setup.java, PeopleStore.java (dao) based on lab-04 code. (The start date of the activity is always the current date.)
2. With XMLMarshaller.java (jaxb) marshalled the instances of above classes into people.xml file and console.
3. Using https://www.freeformatter.com/xsd-generator.html created peoplecat.xsd schema for people.xml.
4. Created classes in people.generate using generate task specified in build.xml.
5. XMLUnMarshaller.java (jaxb) created for unmarshalling objects from people.xml and printing them out to console.
6. JSONMArshaller created to save objects to people.json and print them to console.
7. Queries.java contains all the queries for the people.xml document using xpath. 
