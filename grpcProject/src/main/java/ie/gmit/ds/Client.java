package ie.gmit.ds;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Client {
	
	private static final Logger logger =
            Logger.getLogger(Client.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    public Client(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
       
    }
    
	public static void main(String[] args) throws Exception {
		Client client = new Client("localhost", 50551);

        try {
            client.HashPassword(13, "Tester");
        } finally {
            // Don't stop process, keep alive to receive async response
            client.shutdown();
        }
    }
    
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
    public void HashPassword(int id, String pass) {
        logger.info("Hashing Details: ID " + id + " Password " + pass);
        HashPasswordRequest req = HashPasswordRequest.newBuilder().setId(id).setPassword(pass).build();
        HashPasswordResponse res;
        try {
            res = syncPasswordService.hashPassword(req);
            logger.info(res.toString());
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
 
	}}
