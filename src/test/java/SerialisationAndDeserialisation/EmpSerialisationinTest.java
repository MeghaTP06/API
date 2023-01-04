package SerialisationAndDeserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisation;

public class EmpSerialisationinTest 
{
	@Test
	public void SerialisationofEmpDetails() throws Throwable, JsonMappingException, IOException
	{
		//Create object for Pojo class
		EmpSerialisation emps=new EmpSerialisation("Megha", "M25", "m@gmail.com", 2345, "bangalore");
		
		//Create Object for Object Mapper
		ObjectMapper objm=new ObjectMapper();
		
		//Write the value to json file
		objm.writeValue(new File("./empdata1.json"), emps);
	}

}
