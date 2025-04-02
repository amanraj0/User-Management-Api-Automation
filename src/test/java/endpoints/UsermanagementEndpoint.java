package endpoints;

import lombok.Getter;

@Getter
public enum UsermanagementEndpoint {
    CHANGE_PASSWORD("/api/users/change-password");

    private final String endpoint;

    UsermanagementEndpoint(String endpoint){
        this.endpoint = endpoint;
    }


}
