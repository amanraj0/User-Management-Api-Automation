package constants.authentication.signup;

public enum SignupResponseConstant {

    USER_REGISTERED_SUCCESSFULY("User registered successfully!"),
    USER_NAME_ALREADY_TAKEN("Error: Username is already taken!"),
    USER_EMAIL_ALREADY_TAKEN("Error: Email is already in use!");

    private final String message;

    SignupResponseConstant(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
