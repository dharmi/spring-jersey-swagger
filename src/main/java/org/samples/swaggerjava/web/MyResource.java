
package org.samples.swaggerjava.web;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * 
 * Resource class hosted at the URI path "/myresource"
 *
 * @author 
 */
@Path("/v1/myresource")
@Api(value = "/v1/myresource", description = "MyResource Operations")
@Named
public class MyResource {
	
	@GET
	@Path("/")
	@ApiOperation(value = "simple description of the operation", notes = "Detailed description")
	@ApiResponses(value = { @ApiResponse(code = 600, message = "Invalid xxx"),
			@ApiResponse(code = 200, message = "Successful")})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response simpleGet(){
		return Response.ok("{\"msg\":\"Hello World!\"}", MediaType.APPLICATION_JSON).build();
	}

	/**
	 * List all registered payment sources for a given User
	 * @return
	 */
	@GET
	@Path("/{name}")
	@ApiOperation(value = "simple description of the operation", notes = "Detailed description")
	@ApiResponses(value = { @ApiResponse(code = 600, message = "Invalid xxx"),
			@ApiResponse(code = 200, message = "Successful")})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response complexGet(
			@ApiParam(value = "name", required = true) @PathParam("name") String name,
			@ApiParam(value = "param1", required = false) @PathParam("param1") String param1){

		return Response.ok("{\"msg\":\"Hello , "+name+" \"}", MediaType.APPLICATION_JSON).build();
	}

}
