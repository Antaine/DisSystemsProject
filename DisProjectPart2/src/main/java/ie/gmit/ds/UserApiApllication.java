package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApllication extends Application<UserApiConfig>{

	public static void main(String[] args) throws Exception {
		new UserApiApllication().run(args);
	}
	
	public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {

		final UserApiResources resource = new UserApiResources();

		environment.jersey().register(resource);
	}

}
