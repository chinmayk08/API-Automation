package Base;

import TestData.data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static final Logger logger= LogManager.getLogger(TestBase.class);
    public static String RS1;
    public static String RS2;
    public static String Response;


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    public static void createuser(){
        String name = data.getUserName();
        String job = data.getUserJob();

        // Create request body dynamically
        String requestBody = String.format("{ \"name\": \"%s\", \"job\": \"%s\" }", name, job);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        RS1=response.jsonPath().getString("name");
        RS2=response.jsonPath().getString("job");
        Response="Response: " + response.asPrettyString();
        logger.info("createuser method called successfully");
    }
}

