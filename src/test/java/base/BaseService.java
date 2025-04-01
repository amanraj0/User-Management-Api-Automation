package base;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    public static final String BASE_URL="http://64.227.160.186:8080";

    private RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification = given()
                                .baseUri(BASE_URL);
    }

    protected Response post(Object payload, String endpoint){
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }
}
