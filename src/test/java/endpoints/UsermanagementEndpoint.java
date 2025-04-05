package endpoints;


public enum UsermanagementEndpoint {
    CHANGE_PASSWORD("/api/users/change-password");

    private final String endpoint;

    UsermanagementEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    public String getEndpoint() {
        return this.endpoint;
    }
}
