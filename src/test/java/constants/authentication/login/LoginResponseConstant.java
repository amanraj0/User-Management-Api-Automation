package constants.authentication.login;

import lombok.Getter;

@Getter
public enum LoginResponseConstant {
    USERNAME_PASSWORD_INCORRECT_MESSAGE("The username or password you entered is incorrect"),
    USERNAME_PASSWORD_INCORRECT_ERROR("Invalid Credentials"),
    USERNAME_PASSWORD_INCORRECT_SOLUTION("Please check your credentials and try again");

    private final String message;

    LoginResponseConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
