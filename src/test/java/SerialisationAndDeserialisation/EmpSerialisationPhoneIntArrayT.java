package SerialisationAndDeserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisation;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationEmailStringArray;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationPhoneIntArray;

public class EmpSerialisationPhoneIntArrayT 
{
	@Test
	public void SerialisationofEmpDetails1() throws Throwable, JsonMappingException, IOException
	{
			//Create object for Pojo class
			int[] phoneNo= {98989};
			EmpSerialisationPhoneIntArray emps=new EmpSerialisationPhoneIntArray("Megha", "M05", "m@gmail.com", phoneNo, "Mysore");
			
			//Create Object for Object Mapper
			ObjectMapper objmm=new ObjectMapper();
			
			//Write the value to json file
			objmm.writeValue(new File("./emp3.json"), emps);
	}
}
