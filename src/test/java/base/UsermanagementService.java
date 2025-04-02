package base;

import endpoints.UsermanagementEndpoint;
import io.restassured.response.Response;
import models.request.usermanagement.ChangePasswordRequest;

public class UsermanagementService extends BaseService{

    public Response changePassword(ChangePasswordRequest payload){
        return put(payload, UsermanagementEndpoint.CHANGE_PASSWORD.getEndpoint());
    }
}
