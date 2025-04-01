package base;

import endpoints.AuthenticationEndpoint;
import io.restassured.response.Response;
import models.request.SignupRequest;

public class AuthenticationService extends BaseService{

    public Response signup(SignupRequest payload){
        return post(payload, AuthenticationEndpoint.SIGNUP.getEndpoint());
    }
}
