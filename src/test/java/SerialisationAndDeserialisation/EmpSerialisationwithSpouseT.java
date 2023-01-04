package SerialisationAndDeserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationPhoneIntArray;
import PojoClassForSerialisationAndDeSerialisation.EmpSerialisationwithSpouse;
import PojoClassForSerialisationAndDeSerialisation.Spouse;

public class EmpSerialisationwithSpouseT 
{
	@Test
	public void SerialisationofEmpDetails2() throws Throwable, JsonMappingException, IOException
	{
			//Create object for Pojo class
			Spouse sp=new Spouse("xyz","x10",9805,"Mysore");
			
			EmpSerialisationwithSpouse emps=new EmpSerialisationwithSpouse("abc", "a15", "abc@gmail.com", 7890, "Bangalore");
			//Create Object for Object Mapper
			ObjectMapper objmm=new ObjectMapper();
			
			//Write the value to json file
			objmm.writeValue(new File("./emp4.json"), emps);
	}

}
