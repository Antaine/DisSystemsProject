
package ie.gmit.ds;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class UserClient {


/*	
	//Main
	public static void main(String[] args) throws Exception {
		//Create Client
		UserClient client = new UserClient("localhost", 50551);

		//Hash ID and Password
        try {
            client.HashPassword(13, "Tester");
        } finally {
            // Don't stop process, keep alive to receive async response
            client.shutdown();
        }
    }//End of Main
	
	private static final Logger logger = Logger.getLogger(UserClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    //Build Client
    public UserClient(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
       
    }
    

    //Shutdown
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
    //Sends Hashed Password Request.
    public void HashPassword(int id, String pass) {
        logger.info("Hashing Details: ID " + id + " Password " + pass);
        //Creates Request
        PasswordRequest req = PasswordRequest.newBuilder().setId(id).setPassword(pass).build();
        PasswordResponse res;
        //Get Response
        try {
            res = syncPasswordService.hashPassword(req);
            logger.info(res.toString());
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
 
	}*/}
