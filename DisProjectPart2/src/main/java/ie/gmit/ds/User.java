package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	int userId;
	String name;
	String email;
	String password;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int Id, String name, String email, String password) {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty
	public int getId() {
		return this.userId;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
}
