package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReUseMethods {
	
	public static XmlPath rawToXml(Response r) {

		String respons=r.asString();
		//System.out.println(respons);
		XmlPath xp=new XmlPath(respons);
		
		return xp;
	}
	
	public static JsonPath rawToJSON(Response r) {

		String respons=r.asString();
		//System.out.println(respons);
		JsonPath js=new JsonPath(respons);
		
		return js;
	}


}
