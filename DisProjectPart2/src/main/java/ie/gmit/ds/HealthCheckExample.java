package ie.gmit.ds;

import com.codahale.metrics.health.HealthCheck;


//@Override
public class HealthCheckExample extends HealthCheck{

	protected Result check() throws Exception {
        return Result.healthy();
    }
	
}