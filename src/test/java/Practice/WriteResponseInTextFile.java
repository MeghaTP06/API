package Practice;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import io.restassured.specification.RequestSpecification;

public class WriteResponseInTextFile 
{
	public static void main(String[] args) throws Throwable
	{
		// There is no need to add escape character manually. Just paste string within double quotes.
		//It will automatically add escape sequence as required.
		String jsonString="{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		// Create a request specification
		RequestSpecification rs=RestAssured.given();
		
		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM.
		rs.contentType(ContentType.JSON);
		
		// Adding URI
		rs.baseUri("https://restful-booker.herokuapp.com/auth");
		
		// Adding body as string
		rs.body(jsonString);
		
		// Calling POST method on URI. After hitting we get Response
		Response r=rs.post();
		
		//1st. Method
		//Getting response as a string and writing in to a file
		String responseAsString=r.asString();
		
		// Converting in to byte array before writing
		byte[] responseAsStringByte=responseAsString.getBytes();
		
		// Creating a target file
		File targetFileForString=new File("src/main/resources/targetFileForString1.json");
		
		// Writing into files
		Files.write(responseAsStringByte, targetFileForString);
		
		
		//2nd. Method
		// Getting response as input stream and writing in to a file
		InputStream responseAsInputStream=r.asInputStream();
		
		// Creating a byte array with number of bytes of input stream (available() method)
		byte[] responseAsInputStreamByte=new byte[responseAsInputStream.available()];
		
		// Reads number of bytes from the input stream and stores them into the byte array responseAsInputStreamByte.
		responseAsInputStream.read(responseAsInputStreamByte);
		
		// Creating a target file
		File targetFileForInputStream=new File("src/main/resources/targetFileForInputStream.json");
		
		// Writing into files
		Files.write(responseAsInputStreamByte, targetFileForInputStream);
		
		
		//3rd. Method
		// Directly getting a byte array
		byte[] responseAsByteArray=r.asByteArray();
		
		// Creating a target file
		File targetFileForByteArray=new File("src/main/resources/targetFileForByteArray.json");
		
		// Writing into files
		Files.write(responseAsByteArray, targetFileForByteArray);
	}

}
