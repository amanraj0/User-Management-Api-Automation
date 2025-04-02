package models.response.Authentication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    private String type;
    private int id;
    private String username;
    private String email;
    private String[] roles;
}

