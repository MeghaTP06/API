package PojoClassForSerialisationAndDeSerialisation;

public class EmpSerialisationEmailStringArray 
{
	//Declare Variable Globally
		String Ename;
		String EId;
		String[] Email; //String Array
		int phoneNo;
		String Address;

		//Object Creation
		
	//Create constructor for Intialisation
	public EmpSerialisationEmailStringArray(String ename,String eId,String[] email,int phoneno, String address)
	{
		super();
		Ename=ename;
		EId=eId;
		Email=email;
		phoneNo=phoneno;
		Address=address;
	}
	
	public EmpSerialisationEmailStringArray()
	{
		
	}
	
	//Getter and Setter for Access
	public String getEname() 
	{
		return Ename;
	}


	public void setEname(String ename) 
	{
		Ename = ename;
	}


	public String getEId() 
	{
		return EId;
	}


	public void setEId(String eId) 
	{
		EId = eId;
	}


	public String[] getEmail() 
	{
		return Email;
	}


	public void setEmail(String[] email) 
	{
		Email = email;
	}


	public int getPhoneNo() 
	{
		return phoneNo;
	}


	public void setPhoneNo(int phoneNo) 
	{
		this.phoneNo = phoneNo;
	}


	public String getAddress() 
	{
		return Address;
	}


	public void setAddress(String address) 
	{
		Address = address;
	}

}
