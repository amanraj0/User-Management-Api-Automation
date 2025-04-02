package tests.usermanagement;

import base.UsermanagementService;
import io.restassured.response.Response;
import models.request.usermanagement.ChangePasswordRequest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.authentication.LoginTest;

@Listeners(listeners.TestListeners.class)
public class ChangePasswordTest {

    @Test(description = "Verify that user gets 500 error on providing incorrect current password")
    public void incorrectCurrentPassword(){
        ChangePasswordRequest incorrectCurrentPassword = ChangePasswordRequest.builder()
                .currentPassword("T")
                .newPassword("Aman@54321")
                .confirmPassword("Aman@54321")
                .build();

        UsermanagementService changePasswordService = new UsermanagementService();
        changePasswordService.setAuthToken(LoginTest.loginToken);
        Response response = changePasswordService.changePassword(incorrectCurrentPassword);
        Assert.assertEquals(response.statusCode(),500,"Response Status should be 500");

    }

    @Test(description = "Verify that user is able to change the password and gets 200 status code")
    public void changePassword(){
        ChangePasswordRequest validCredentials = ChangePasswordRequest.builder()
                .currentPassword("aman@12345")
                .newPassword("Aman@54321")
                .confirmPassword("Aman@54321")
                .build();

        UsermanagementService changePasswordService = new UsermanagementService();
        changePasswordService.setAuthToken(LoginTest.loginToken);
        Response response = changePasswordService.changePassword(validCredentials);
        Assert.assertEquals(response.statusCode(),200,"Response Status should be 200");

    }
}
