package SerialisationAndDeserialisation;

import java.io.File;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisation;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationEmailStringArray;

public class EmpDeSerialisationEmailStringArray 
{
	@Test
	public void deserialisationofEmpDetails() throws Throwable, JsonMappingException, Throwable
	{
		//Step 1: Create the object for object Mapper
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:Read the value from object mapper
		EmpSerialisationEmailStringArray empse=objm.readValue(new File("./emp2.json"),  EmpSerialisationEmailStringArray.class);
		
		//Step 3:Fetch the required value for JSON file
		String[] email=empse.getEmail();
		for(int i=0;i<email.length;i++)
		{
		System.out.println(email[i]);
		}
	}

}
