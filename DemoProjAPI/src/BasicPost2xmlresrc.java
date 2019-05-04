import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import files.ReUseMethods;

public class BasicPost2xmlresrc {
	
	
	@Test
	public void postReqData() throws IOException {
		
		
		String postxmldata=GenerateStringFromResource("D:\\work\\Rest API\\postXmlData.xml");
		RestAssured.baseURI="http://216.10.245.166";
		//"https://maps.googleapis.com";
		
		Response res= given().
		queryParam("key","AIzaSyAQj47UIuA1H0ETz8hClmxajJr9yC2iKdQ").
		body(postxmldata).		
					when().
					post("maps/api/place/add/xml").
					then().assertThat().
					statusCode(200).
					and().contentType(ContentType.XML).
					extract().response();
		
		
		XmlPath xp=ReUseMethods.rawToXml(res);
		
		String place_idxml= xp.get("response.place_id");
		System.out.println("XML PLACE ID : "+place_idxml);
		//.and().
			//		body("status",equalTo("OK"));
		
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
