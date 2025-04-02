package tests.authentication;

import base.AuthenticationService;
import constants.authentication.login.LoginResponseConstant;
import io.restassured.response.Response;
import models.request.authentication.LoginRequest;
import models.response.Authentication.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Helper;

@Listeners(listeners.TestListeners.class)
public class LoginTest {
    public static String loginToken = null;

    @Test(description = "Verify that user gets 401 and error message on providing incorrect combination of username and password")
    public void incorrectCombinationForUsernamePassword(){
        LoginRequest mismatchUsernameAndPassword = LoginRequest.builder()
                                                        .username("incorrectUser")
                                                        .password("incorrectPassword")
                                                        .build();
        AuthenticationService loginService = new AuthenticationService();

        Response response = loginService.login(mismatchUsernameAndPassword);
        Assert.assertEquals(response.statusCode(),401,"Response status code is not 401");
        String actualErrorMsg = (String) Helper.get(response.asString(),"error");
        Assert.assertEquals(actualErrorMsg, LoginResponseConstant.USERNAME_PASSWORD_INCORRECT_ERROR.getMessage(),"Username password mismatch error is not as expected");
    }

    @Test(description = "Verify that on successful login user gets the 200 status code along with token")
    public void loginWithValidCredentials(){
        LoginRequest validCredential = LoginRequest.builder()
                                            .username("aman")
                                            .password("aman@1234")
                                            .build();

        AuthenticationService loginService = new AuthenticationService();
        Response response = loginService.login(validCredential);
        Assert.assertEquals(response.statusCode(),200,"Login response should be 200 for successful login");
        LoginResponse actualLoginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(actualLoginResponse.getUsername(),validCredential.getUsername(),"Username in response is not matching with the logged in user");
        loginToken = actualLoginResponse.getToken();
    }

}
