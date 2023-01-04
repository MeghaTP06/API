package SerialisationAndDeserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisation;

public class EmpDeSerialisation 
{
	@Test
	public void deserialisationofEmpDetails() throws Throwable, JsonMappingException, Throwable
	{
		//Step 1: Create the object for object Mapper
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:Read the value from object mapper
		EmpSerialisation emps=objm.readValue(new File("./empdata1.json"), EmpSerialisation.class);
		
		//Step 3:Fetch the required value for JSON file
		System.out.println(emps.getEname());
	}

}
