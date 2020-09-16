import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        RestAssured.baseURI ="https://swapi.dev/api/";
        RestAssured.useRelaxedHTTPSValidation();
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Terminating Suite");
    }

}
