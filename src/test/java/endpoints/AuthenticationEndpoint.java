package endpoints;

public enum AuthenticationEndpoint {
    LOGIN("api/auth/login"),
    FORGOT_PASSWORD("api/auth/forgot-password"),
    RESET_PASSWORD("api/auth/reset-password"),
    SIGNUP("api/auth/signup");

    private final String endpoint;

    AuthenticationEndpoint(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
