import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class Basics {

	@Test
public void test() {
	//public static void main(String[] args) {
		
/*
https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362
&radius=1500&type=restaurant&keyword=cruise&key=AIzaSyAQj47UIuA1H0ETz8hClmxajJr9yC2iKdQ

 */
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
//				param("type","restaurant").
//				param("keyword","cruise").
				param("key","AIzaSyAQj47UIuA1H0ETz8hClmxajJr9yC2iKdQ").
				when().
				get("maps/api/place/nearbysearch/json").
				then().assertThat().
				statusCode(200).
				and().contentType(ContentType.JSON).and().
			//	body("results[0].geometry.location.lat",equalTo("-33.8688197"));
				body("results[0].name",equalTo("Sydney")).and().
				body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
				header("Server ",equalTo("scaffolding on HTTPServer2"));
				
		

	}

}
