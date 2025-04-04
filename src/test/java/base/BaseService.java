package base;

import static io.restassured.RestAssured.*;
import filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    public static final String BASE_URL = System.getProperty("baseUrl");

    private final RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        requestSpecification = given()
                                .baseUri(BASE_URL);
    }

    public void setAuthToken(String token){
        requestSpecification.header(
                "Authorization",
                "Bearer " + token
        );
    }

    protected Response post(Object payload, String endpoint){
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    protected Response put(Object payload, String endpoint){
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);
    }
}
