package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	static int userId;
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
	public static int getId() {
		return userId;
	}
	
	@JsonProperty
	public void setId(int id)
	{
		this.userId = id;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}
	
	@JsonProperty
	public void setName(String name)
	{
		this.name = name;
	}
	@JsonProperty
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
/*	
public static void main(String[] args) throws Exception {
		String password 
		System.out.println("Enter Password: ");
		String password = input.nextLine();
		System.out.println("Enter ID: ");
		int id = input.nextInt();
		
		
		
		UserClient client = new UserClient("localhost", 50051);
		try {
			client.hashPassword(id, password);
		} finally {
			client.shutdown();
		}*/
	}

