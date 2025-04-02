package base;

import endpoints.AuthenticationEndpoint;
import io.restassured.response.Response;
import models.request.authentication.LoginRequest;
import models.request.authentication.SignupRequest;

public class AuthenticationService extends BaseService{

    public Response signup(SignupRequest payload){
        return post(payload, AuthenticationEndpoint.SIGNUP.getEndpoint());
    }

    public Response login(LoginRequest payload){
        return post(payload,AuthenticationEndpoint.LOGIN.getEndpoint());
    }
}
