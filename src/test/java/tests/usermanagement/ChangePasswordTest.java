package tests.usermanagement;

import base.AuthenticationService;
import base.UsermanagementService;
import io.restassured.response.Response;
import models.request.authentication.LoginRequest;
import models.request.usermanagement.ChangePasswordRequest;
import models.response.Authentication.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.authentication.LoginTest;
import utils.Helper;

@Listeners(listeners.TestListeners.class)
public class ChangePasswordTest {
    String loginToken;
    Helper helper = new Helper();


    @Test(description = "Verify that user gets 500 error on providing incorrect current password",
            priority = 1
    )
    public void incorrectCurrentPassword(){
        ChangePasswordRequest incorrectCurrentPasswordData = ChangePasswordRequest.builder()
                .currentPassword(helper.read("IncorrectPassword"))
                .newPassword(helper.read("NewValidPassword"))
                .confirmPassword(helper.read("NewValidPassword"))
                .build();

        UsermanagementService changePasswordService = new UsermanagementService();
        changePasswordService.setAuthToken(loginToken);
        Response response = changePasswordService.changePassword(incorrectCurrentPasswordData);
        Assert.assertEquals(response.statusCode(),500,"Response Status should be 500");

    }

    @Test(description = "Verify that on successful login user gets the 200 status code along with token",
    priority=0)
    public void loginWithValidCredentials(){
        LoginRequest validCredential = LoginRequest.builder()
                .username(helper.read("ValidUsername"))
                .password(helper.read("ValidPassword"))
                .build();

        AuthenticationService loginService = new AuthenticationService();
        Response response = loginService.login(validCredential);
        Assert.assertEquals(response.statusCode(),200,"Login response should be 200 for successful login");
        LoginResponse actualLoginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(actualLoginResponse.getUsername(),validCredential.getUsername(),"Username in response is not matching with the logged in user");
        loginToken = actualLoginResponse.getToken();
    }

    @Test(
            description = "Verify that user is able to change the password and gets 200 status code",
            dependsOnMethods = "loginWithValidCredentials"

    )
    public void changePassword(){
        ChangePasswordRequest validCredentials = ChangePasswordRequest.builder()
                .currentPassword(helper.read("ValidPassword"))
                .newPassword(helper.read("NewValidPassword"))
                .confirmPassword(helper.read("NewValidPassword"))
                .build();

        UsermanagementService changePasswordService = new UsermanagementService();
        changePasswordService.setAuthToken(loginToken);
        Response response = changePasswordService.changePassword(validCredentials);
        Assert.assertEquals(response.statusCode(),200,"Response Status should be 200");

    }

}
