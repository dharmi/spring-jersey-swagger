package org.samples.swaggerjava.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Sample Rest Client:
 * 
 */
public class RestClient {

	public static void main(String... args) throws Exception{
		new RestClient().testMethod();
	}
	
	public void testMethod(){
		Client client = Client.create();
		String apiURI = "http://localhost:8080/api/v1/myresource/dharmi";

		// invoke the API
		WebResource webResource = client.resource(apiURI);

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		int status = response.getStatus();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			System.err.println("Failed : HTTP error code : " + response.getStatus());
		} else{
			System.out.println("output was successful.");
		}
	}

}



