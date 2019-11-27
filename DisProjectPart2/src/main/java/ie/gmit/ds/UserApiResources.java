package ie.gmit.ds;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)

public class UserApiResources {
	private HashMap<Integer, User> usersMap = new HashMap<>();

	public UserApiResources() {
	    User testUser = new User(1,"Antaine","1234@gmail.com", "1234");
	    usersMap.put(testUser.getId(), testUser);
	}

	 @GET
	  public Collection<User> getUsers() {
	      // artistsMap.values() returns Collection<Artist>
	      // Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
	      // it's basically a generic list.
	      // https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
	      
	      return usersMap.values();
	  }
}
