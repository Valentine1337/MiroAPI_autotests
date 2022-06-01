package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static config.Api.apiConfig;
import static helpers.CustomAllureListeners.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpec =
            with()
                    .filter(withCustomTemplates())
                    .baseUri("https://api.miro.com/v2")
                    .auth().oauth2(apiConfig.token())
                    .accept("application/json")
                    .contentType(ContentType.JSON)
                    .log().body();

    public static ResponseSpecification response201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}