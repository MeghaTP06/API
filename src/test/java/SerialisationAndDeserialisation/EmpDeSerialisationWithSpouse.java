package SerialisationAndDeserialisation;

import java.io.File;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationPhoneIntArray;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationwithSpouse;

public class EmpDeSerialisationWithSpouse 
{
	@Test
	public void deserialisationofEmpDetails() throws Throwable, JsonMappingException, Throwable
	{
		//Step 1: Create the object for object Mapper
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:Read the value from object mapper
		EmpSerialisationwithSpouse empp=objm.readValue(new File("./emp4.json"),  EmpSerialisationwithSpouse.class);
		
		//Step 3:Fetch the required value for JSON file
		System.out.println(empp.getPhoneNo());
		System.out.println(empp.getEname());
	}

}
