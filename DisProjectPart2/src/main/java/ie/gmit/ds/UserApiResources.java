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
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)

public class UserApiResources {     

	private Validator validator;
	 
	
    @GET
    public Response getUsers() {
        return (Response) BackEnd.getUsers();
    }
    
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Integer id) {
        User user = BackEnd.getUserById(id);
        if (user != null)
            return Response.ok(user).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }
    
    @POST
   public Response createUsers(User user) throws URISyntaxException {
       // validation
       Set<ConstraintViolation<User>> violations = validator.validate(user);
       User e = BackEnd.getUserById(user.getId());
       if (violations.size() > 0) {
           ArrayList<String> validationMessages = new ArrayList<String>();
           for (ConstraintViolation<User> violation : violations) {
               validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
           }
           return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
       }
       if (e != null) {
           BackEnd.updateUser(user.getId(), user);
           return Response.created(new URI("/users/" + user.getId()))
                   .build();
       } else
           return Response.status(Status.NOT_FOUND).build();
   }
    
    @POST
    public Response createUser(User users) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<User>> violations = validator.validate(users);
        User e = BackEnd.getUserById(User.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<User> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            BackEnd.updateUser(users.getId(), users);
            return Response.created(new URI("/employees/" + users.getId()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateUserById(@PathParam("id") Integer id, User user) {
        // validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        User e = BackEnd.getUserById(user.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<User> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            user.setId(id);
            BackEnd.updateUser(id, user);
            return Response.ok(user).build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response removeUserById(@PathParam("id") Integer id) {
        User user = BackEnd.getUserById(id);
        if (user != null) {
            BackEnd.removeUser(id);
            return Response.ok().build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
    
     
}
