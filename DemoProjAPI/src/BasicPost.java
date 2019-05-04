import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicPost {
	
	
	@Test
	public void postReqData() {
		
		RestAssured.baseURI="http://216.10.245.166";
		//"https://maps.googleapis.com";
		
		given().
		queryParam("key","AIzaSyAQj47UIuA1H0ETz8hClmxajJr9yC2iKdQ").
		body("{" + 
				"\"location\":{" + 
				"\"lat\" : -38.383494," + 
				"\"lng\" : 33.427362" + 
				"}," + 
				"\"accuracy\":50," + 
				"\"name\":\"Frontline house\"," + 
				"\"phone_number\":\"(+91) 983 893 3937\"," + 
				"\"address\" : \"29, side layout, cohen 09\"," + 
				"\"types\": [\"shoe park\",\"shop\"]," + 
				"\"website\" : \"http://google.com\"," + 
				"\"language\" : \"French-IN\"" + 
				"}").		
					when().
					post("maps/api/place/add/json").
					then().assertThat().
					statusCode(200).
					and().contentType(ContentType.JSON).and().
					body("status",equalTo("OK"));
		
	}

}
