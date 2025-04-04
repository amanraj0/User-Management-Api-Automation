package tests.authentication;

import base.AuthenticationService;
import constants.authentication.signup.SignupResponseConstant;
import io.restassured.response.Response;
import models.request.authentication.SignupRequest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Helper;

@Listeners(listeners.TestListeners.class)
public class SignupTest {

    Helper helper = new Helper();

    @Test(description = "Verify that username is a mandatory field for signup and user gets 500 status code")
    public void usernameMandatoryForSignup(){
        SignupRequest signUpWithoutUsername =  SignupRequest.builder()
                .username("")
                .password(helper.read("ValidPassword"))
                .email(helper.read("ValidEmail"))
                .firstName(helper.read("Firstname"))
                .lastName(helper.read("Lastname"))
                .mobileNumber(helper.read("MobileNumber"))
                .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutUsername);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }


    @Test(description = "Verify that password is a mandatory field for signup and user gets 500 status code")
    public void passwordMandatoryForSignup(){
        SignupRequest signUpWithoutPassword =  SignupRequest.builder()
                .username(helper.read("ValidUsername"))
                .password("")
                .email(helper.read("ValidEmail"))
                .firstName(helper.read("Firstname"))
                .lastName(helper.read("Lastname"))
                .mobileNumber(helper.read("MobileNumber"))
                .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutPassword);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }

    @Test(description = "Verify that email is a mandatory field for signup and user gets 500 status code")
    public void emailMandatoryForSignup(){
        SignupRequest signUpWithoutEmail =  SignupRequest.builder()
                .username(helper.read("ValidUsername"))
                .password(helper.read("ValidPassword"))
                .email("")
                .firstName(helper.read("Firstname"))
                .lastName(helper.read("Lastname"))
                .mobileNumber(helper.read("MobileNumber"))
                .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutEmail);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }

    @Test(description = "Verify that First Name is a mandatory field for signup and user gets 500 status code")
    public void firstnameMandatoryForSignup(){
        SignupRequest signUpWithoutFirstName =  SignupRequest.builder()
                .username(helper.read("ValidUsername"))
                .password(helper.read("ValidPassword"))
                .email(helper.read("ValidEmail"))
                .firstName("")
                .lastName(helper.read("Lastname"))
                .mobileNumber(helper.read("MobileNumber"))
                .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutFirstName);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }

    @Test(description = "Verify that Last Name is a mandatory field for signup and user gets 500 status code")
    public void lastnameMandatoryForSignup(){
        SignupRequest signUpWithoutLastName =  SignupRequest.builder()
                .username(helper.read("ValidUsername"))
                .password(helper.read("ValidPassword"))
                .email(helper.read("ValidEmail"))
                .firstName(helper.read("Firstname"))
                .lastName("")
                .mobileNumber(helper.read("MobileNumber"))
                .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutLastName);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }

    @Test(description = "Verify that Mobile number is a mandatory field for signup and user gets 500 status code")
    public void mobileNumberMandatoryForSignup(){
        SignupRequest signUpWithoutMobileNumber =  SignupRequest.builder()
                                                            .username(helper.read("ValidUsername"))
                                                            .password(helper.read("ValidPassword"))
                                                            .email(helper.read("ValidEmail"))
                                                            .firstName(helper.read("Firstname"))
                                                            .lastName(helper.read("Lastname"))
                                                            .mobileNumber("")
                                                            .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signUpWithoutMobileNumber);
        Assert.assertEquals(response.statusCode(),500,"Response Status code should be 500");
    }

    @Test(description = "Verify that user is able to signup on providing all valid parameters")
    public void signupUserWithValidParameter(){
        SignupRequest signupUser = SignupRequest.builder()
                                        .username(helper.read("ValidUsername"))
                                        .password(helper.read("ValidPassword"))
                                        .email(helper.read("ValidEmail"))
                                        .firstName(helper.read("Firstname"))
                                        .lastName(helper.read("Lastname"))
                                        .mobileNumber(helper.read("MobileNumber"))
                                        .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signupUser);
        Assert.assertEquals(response.statusCode(),200,"Response status code should be 200");
        Assert.assertEquals(response.asPrettyString(), SignupResponseConstant.USER_REGISTERED_SUCCESSFULY.getMessage(),"Success User registration response message is not as expected");

    }

    @Test(
            description = "Verify that user gets an error on providing already registered user name",
            dependsOnMethods = {"signupUserWithValidParameter"}
    )
    public void alreadyRegisteredUsernameForSignup(){
        SignupRequest signupUser = SignupRequest.builder()
                                        .username(helper.read("ValidUsername"))
                                        .password(helper.read("ValidPassword"))
                                        .email(helper.read("ValidEmail"))
                                        .firstName(helper.read("Firstname"))
                                        .lastName(helper.read("Lastname"))
                                        .mobileNumber(helper.read("MobileNumber"))
                                        .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signupUser);
        Assert.assertEquals(response.statusCode(),400,"Response status code should be 400");
        Assert.assertEquals(response.asPrettyString(), SignupResponseConstant.USER_NAME_ALREADY_TAKEN.getMessage(),"Already registered User error message is not as expected");

    }

    @Test(
            description = "Verify that user gets an error on providing already registered email",
            dependsOnMethods = {"signupUserWithValidParameter"}
    )
    public void alreadyRegisteredEmailForSignup(){
        SignupRequest signupUser = SignupRequest.builder()
                                        .username(helper.read("NewValidUsername"))
                                        .password(helper.read("ValidPassword"))
                                        .email(helper.read("ValidEmail"))
                                        .firstName(helper.read("Firstname"))
                                        .lastName(helper.read("Lastname"))
                                        .mobileNumber(helper.read("MobileNumber"))
                                        .build();

        AuthenticationService signupService = new AuthenticationService();
        Response response = signupService.signup(signupUser);
        Assert.assertEquals(response.statusCode(),400,"Response status code should be 400");
        Assert.assertEquals(response.asPrettyString(), SignupResponseConstant.USER_EMAIL_ALREADY_TAKEN.getMessage(),"Already registered Email error message is not as expected");

    }
}
