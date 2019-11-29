package ie.gmit.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)

public class UserApiResources {


	
     

    @GET
    public Response getUsers() {
        return (Response) BackEnd.getUsers();
    }
 /*
    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Integer id) {
        Employee employee = EmployeeDB.getEmployee(id);
        if (employee != null)
            return Response.ok(employee).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }
    
    public Response getUserByID() {
    	
    }

	 @GET
	  public Collection<User> getUsers() {
	      // artistsMap.values() returns Collection<Artist>
	      // Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
	      // it's basically a generic list.
	      // https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
	      
	      return usersMap.values();
	  }*/
	 
	/* @GET
	    @Path("/{id}")
	    public Response getUserById(@PathParam("id") Integer id) {
	        User user = User.getUser(id);
	        if (employee != null)
	            return Response.ok(employee).build();
	        else
	            return Response.status(Status.NOT_FOUND).build();
	    }*/
}
