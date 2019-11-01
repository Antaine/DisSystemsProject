package ie.gmit.ds;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PassServer {

	//Main
	 public static void main(String[] args) throws IOException, InterruptedException {
		 //Runs Server
	        final PassServer Server = new PassServer();
	        Server.start();
	        Server.blockUntilShutdown();
	    }//End of Main

	
	private Server grpcServer;
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private static final int PORT = 50551;
    
    //Starts Server
    private void start() throws IOException {
        grpcServer = ServerBuilder.forPort(PORT)
                .addService(new PasswordServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening for Password " + PORT);

    }

    //Ends Server
    private void stop() {
        if (grpcServer != null) {
            grpcServer.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (grpcServer != null) {
            grpcServer.awaitTermination();
        }
    }

}
