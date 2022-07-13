import com.momo.grpc.UserGrpc;
import com.momo.grpc.UserGrpc.UserBlockingStub;
import com.momo.grpc.UserOuterClass.APIResponse;
import com.momo.grpc.UserOuterClass.LoginRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

		UserBlockingStub userSub = UserGrpc.newBlockingStub(channel);

		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();

		APIResponse response = userSub.login(loginRequest);

		System.out.println(response.getResponseMessage());
	}

}
