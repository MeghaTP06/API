package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con=null;
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.dbURL, IPathConstant.dbUsername, IPathConstant.dbPassword);
	}
	
	public String readDataFromDBAndValidate(String query,int columnIndex,String expectedData) throws Throwable
	{
		boolean flag=false;
		ResultSet result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Verified");
			return expectedData;
		}
		else
		{
			System.out.println("Not Verified");
			return "";
		}
	}

	public void CloseDB() throws SQLException
	{
		con.close();
	}
}
