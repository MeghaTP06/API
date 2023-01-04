package Practice;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class uploadImage 
{
	@Test
	public void FileUpload()
	{
		//Create File Instance using "new"
		File f=new File("C:\\Users\\admin\\Downloads\\IMG-20220421-WA0014.jpg");
		
		//multipart-String,Object,Content Type
		given().multiPart("File",f,"multipart/form-data")
		
		//Post the request in website
		.post("https://the-internet.herkuapp.com/upload")
		
		//thenReturn() method
		.thenReturn().then().log().all();
	}
}
