package ie.gmit.ds;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

	private ArrayList<Passwords> passwordList;
    private static final Logger logger =
            Logger.getLogger(PasswordServiceImpl.class.getName());

    public PasswordServiceImpl() {
        passwordList = new ArrayList<>();
        
        //createDummyItems();
    }


  /*  public void getPasswords(Empty request,
                         StreamObserver<Passwords> responseObserver) {
        Passwords.Builder passwords = Passwords.();
        for (Item item : itemsList) {
            items.addItems(item);
        }
        responseObserver.onNext(items.build());
        responseObserver.onCompleted();
    }
*/
    
    /*
    private void createDummyItems() {
        itemsList.add(Item.newBuilder()
                .setName("First Item")
                .setId("001")
                .setDescription("A cool item")
                .build());
        itemsList.add(Item.newBuilder()
                .setName("Second Item")
                .setId("002")
                .setDescription("An even cooler item")
                .build());
        itemsList.add(Item.newBuilder()
                .setName("Third Item")
                .setId("003")
                .setDescription("A crap item")
                .build());
    }*/
}
