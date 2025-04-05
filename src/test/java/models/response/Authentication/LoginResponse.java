package models.response.Authentication;

public class LoginResponse {
    private String token;
    private String type;
    private int id;
    private String username;
    private String email;
    private String[] roles;

    LoginResponse(){}

    LoginResponse(String token, String type, int id, String username, String email, String[] roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public static LoginResponseBuilder builder() {
        return new LoginResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String[] getRoles() {
        return this.roles;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginResponse)) return false;
        final LoginResponse other = (LoginResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        if (!java.util.Arrays.deepEquals(this.getRoles(), other.getRoles())) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        result = result * PRIME + this.getId();
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        result = result * PRIME + java.util.Arrays.deepHashCode(this.getRoles());
        return result;
    }

    public String toString() {
        return "LoginResponse(token=" + this.getToken() + ", type=" + this.getType() + ", id=" + this.getId() + ", username=" + this.getUsername() + ", email=" + this.getEmail() + ", roles=" + java.util.Arrays.deepToString(this.getRoles()) + ")";
    }

    public static class LoginResponseBuilder {
        private String token;
        private String type;
        private int id;
        private String username;
        private String email;
        private String[] roles;

        LoginResponseBuilder() {
        }

        public LoginResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public LoginResponseBuilder type(String type) {
            this.type = type;
            return this;
        }

        public LoginResponseBuilder id(int id) {
            this.id = id;
            return this;
        }

        public LoginResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public LoginResponseBuilder roles(String[] roles) {
            this.roles = roles;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(this.token, this.type, this.id, this.username, this.email, this.roles);
        }

        public String toString() {
            return "LoginResponse.LoginResponseBuilder(token=" + this.token + ", type=" + this.type + ", id=" + this.id + ", username=" + this.username + ", email=" + this.email + ", roles=" + java.util.Arrays.deepToString(this.roles) + ")";
        }
    }
}

