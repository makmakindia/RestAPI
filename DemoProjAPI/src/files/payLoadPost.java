package files;

public class payLoadPost {
	
	public static String postPayLoad() {
		
		String postAddPlace="{" + 
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
				"}";
		
		return postAddPlace;
	}
	
	public static String payLoadPostDeletePlace(String placeId) {
		
		String deleteplacebody="{"+
				   "\"place_id\":\""+placeId+"\" "+
				    	"}";
		
		return deleteplacebody;
	}

}
