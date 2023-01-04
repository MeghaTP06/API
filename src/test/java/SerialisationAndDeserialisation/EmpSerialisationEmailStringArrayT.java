package SerialisationAndDeserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisation;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationEmailStringArray;

public class EmpSerialisationEmailStringArrayT 
{
	@Test
	public void SerialisationofEmpDetails1() throws Throwable, JsonMappingException, IOException
	{
			//Create object for Pojo class
			String[] email= {"m1@gmail.com"};
			EmpSerialisationEmailStringArray empss=new EmpSerialisationEmailStringArray("Megha", "M25", email, 2345, "bangalore");
			
			//Create Object for Object Mapper
			ObjectMapper objmm=new ObjectMapper();
			
			//Write the value to json file
			objmm.writeValue(new File("./emp2.json"), empss);
	}
}
