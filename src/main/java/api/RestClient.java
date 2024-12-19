package api;

import constants.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RestClient {
    public static RequestSpecification getBaseSpec() {

        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(Constants.BASE_URL)
                .build();
    }
}
