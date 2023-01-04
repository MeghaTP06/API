package SerialisationAndDeserialisation;

import java.io.File;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationEmailStringArray;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationPhoneIntArray;

public class EmpDeSerialisationPhoneIntArray 
{
	@Test
	public void deserialisationofEmpDetails() throws Throwable, JsonMappingException, Throwable
	{
		//Step 1: Create the object for object Mapper
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:Read the value from object mapper
		EmpSerialisationPhoneIntArray empp=objm.readValue(new File("./emp3.json"),  EmpSerialisationPhoneIntArray.class);
		
		//Step 3:Fetch the required value for JSON file
		int[] phoneno=empp.getPhoneNo();
		for(int i=0;i<phoneno.length;i++)
		{
		System.out.println(phoneno[i]);
		}
	}
}
