package models.request.authentication;

public class LoginRequest {
    private String username;
    private String password;

    LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginRequestBuilder builder() {
        return new LoginRequestBuilder();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class LoginRequestBuilder {
        private String username;
        private String password;

        LoginRequestBuilder() {
        }

        public LoginRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this.username, this.password);
        }

        public String toString() {
            return "LoginRequest.LoginRequestBuilder(username=" + this.username + ", password=" + this.password + ")";
        }
    }
}
