package org.demo.xstream.domain;

import org.apache.log4j.Logger;
import org.demo.xstream.utils.XStreamUtils;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XMLtoObjectTest {
	private static final Logger logger = Logger.getLogger(XMLtoObjectTest.class);
	
	@Test
	public void testXMLtoObject(){
        
		XStream xstream = new XStream(new StaxDriver());
		
		String xml = XStreamUtils.getStringFromFile("student.xml");
		
		System.out.println(xml);
		
		Student joe = (Student) xstream.fromXML(xml);
				
		logger.info("[testXMLtoObject] called");
	}
	
	@Test
	public void testObjectToXML(){
		XStream xstream = new XStream(new StaxDriver());
	      
	    Student student = getStudentDetails();
		String xml = xstream.toXML(student);
	    System.out.println(xml);
	}
	
	 private Student getStudentDetails(){
	      Student student = new Student();
	      student.setFirstName("Mahesh");
	      student.setLastName("Parashar");
	      student.setRollNo(1);
	      student.setClassName("1st");

	      Address address = new Address();
	      address.setArea("H.No. 16/3, Preet Vihar.");
	      address.setCity("Delhi");
	      address.setState("Delhi");
	      address.setCountry("India");
	      address.setPincode(110012);

	      student.setAddress(address);
	      return student;
	   }
}
