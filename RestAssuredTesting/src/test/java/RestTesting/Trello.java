package RestTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Trello {
	
//Don't you thin the base url is common for all the action
	public static String baseurl = "https://api.trello.com";
	
	@Test (priority = 0)
	public void createBoard()
	{
		//i want to fetch the base url.so that i can add other things to that base url
		//this is the first step to provide the base url to the request
		RestAssured.baseURI = baseurl;
		
	    //in rest assured we have 3 keywords
		//given:precondition includes like parameter,header,authorization
		//when: condition is an testing like resource//wehave to provide the name//that is called response/1/board/and the method name
		//then : post condition: is something like response check the response
		
		given().queryParam("name", "prashanth junit Board")
		.queryParam("key", "90a62826b2d1d6aafd8e231adca224d0")
		.queryParam("token", "8b789a493021bae56407849b2ea14ba12c77f79fa83d5b3f685b32a55f76cdd5")
		.header("Content-Type", "application/json")
		
		.when()
		.post("/1/boards/")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
	}
}