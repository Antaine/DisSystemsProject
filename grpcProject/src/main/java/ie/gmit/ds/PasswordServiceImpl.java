package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

	private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

	public PasswordServiceImpl() {

	}
	//Implements passwords.proto Methods
	@Override
	public void hashPassword(PasswordRequest req, StreamObserver<PasswordResponse> resObserver)
	{
		String pass = req.getPassword();
		char[] hashPass = pass.toCharArray();
		byte[] salt = PasswordCreate.getNextSalt();
		byte[] finishedPass = PasswordCreate.hash(hashPass, salt);
		
		//Response to Request
		resObserver.onNext(PasswordResponse.newBuilder().setId(req.getId()).setPasswordHashed(ByteString.copyFrom(finishedPass))
				.setSalt(ByteString.copyFrom(salt)).build());
		resObserver.onCompleted();
	}
	
	//Validates Password
	@Override
	public void validatePassword(ValidRequest req, StreamObserver resObserver)
	{
		char[] password = req.getPassword().toCharArray();
		byte[] finishedPass = req.getPasswordHashed().toByteArray();
		byte[] salt = req.getSalt().toByteArray();
		
		resObserver.equals(PasswordCreate.isExpectedPassword(password, salt, finishedPass));
	}
	
	
}
