package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Validator;

public class BackEnd {

	private static HashMap<Integer, User> usersMap = new HashMap<>();
	
	public void UserApiResources() {
	    User testUser = new User(1,"Antaine","1234@gmail.com", "1234");
	    usersMap.put(testUser.getId(), testUser);
	}
	
	private Validator validator;
	 
    public void UserApiApllication(Validator validator) {
        this.validator = validator;
    }
    
    public static List <User> getUsers(){
    	return new ArrayList<User>(usersMap.values());
    }
    
    public User getUserById(int id)
    {
    	return usersMap.get(id);
    }

    public static void removeUser(Integer id){
        usersMap.remove(id);
    } 
    
    public static void updateUser(Integer id, User user){
        usersMap.put(id, user);
    }
    
    public static void addUser(Integer id, User user){
        usersMap.put(id, user);
    }
}
