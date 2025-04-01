package models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

}