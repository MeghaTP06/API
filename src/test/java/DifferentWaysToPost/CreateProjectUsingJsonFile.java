package DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

public class CreateProjectUsingJsonFile 
{
	@Test
	public void test()
	{
		File file=new File("./src/main/resources/pojoecl.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.log()
		.all();
	}

}
