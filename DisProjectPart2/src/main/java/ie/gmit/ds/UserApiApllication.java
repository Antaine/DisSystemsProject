package ie.gmit.ds;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserApiApllication extends Application<UserApiConfig>{

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserApiApllication.class);
	public static void main(String[] args) throws Exception {
		new UserApiApllication().run(args);
	}
	
	
	public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {

		final UserApiResources resource = new UserApiResources();

		environment.jersey().register(resource);
	}

}
