
import com.sampletest.beans.Person;
import com.sampletest.beans.User;
import com.sampletest.beans.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
        import io.restassured.response.Response;
        import org.apache.http.HttpStatus;
import org.json.JSONObject;
        import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SampleTest extends BaseTest  {
    @Test
    public void getVehicleByIdTest() throws IOException {
        String apiPath="vehicles/14/";
        Response getResponse = given()
                .when()
                .request(Method.GET, apiPath)
                .then()
                .extract()
                .response();
        Vehicle vehicle=new ObjectMapper().readValue(getResponse.asString(), Vehicle.class);
        JSONObject jsonObject = new JSONObject(getResponse.asString());
        assertThat(getResponse.getStatusCode(), is(HttpStatus.SC_OK));
        assertThat(vehicle.getName(),is("Snowspeeder"));
        assertThat(vehicle.getModel(),is("t-47 airspeeder"));
    }


    @Test
    public void getPersonByIdTest() throws IOException {
        String apiPath="people/1/";
        Response getResponse = given()
                .when()
                .request(Method.GET, apiPath)
                .then()
                .extract()
                .response();
        Person person=new ObjectMapper().readValue(getResponse.asString(), Person.class);
        JSONObject jsonObject = new JSONObject(getResponse.asString());
        assertThat(getResponse.getStatusCode(), is(HttpStatus.SC_OK));
        assertThat(person.getName(),is("Luke Skywalker"));
        assertThat(person.getHeight(),is("172"));
        assertThat(person.getFilms().size(),greaterThan(0));
        assertThat(person.getVehicles().size(),greaterThan(0));
        assertThat(person.getStarships().size(),greaterThan(0));
    }

    @Test
    public void createUserTest() throws IOException {
        String apiPath="https://gorest.co.in/public-api/users";

        String body="{\n" +
                "    \"name\": \"test user\",\n" +
                "    \"email\": \"test@xyz1.com\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"status\": \"Active\"\n" +
                "}";
        Response getResponse = given()
                .contentType("application/json")
                .header("Authorization","Bearer e0c323fbe43d178075e0f9152edad4f14a7e0940cb880015e8e64240aa1bfda2")
                .when()
                .body(body)
                .request(Method.POST, apiPath)
                .then()
                .extract()
                .response();
        assertThat(getResponse.getStatusCode(), is(HttpStatus.SC_OK));


        JSONObject jsonObject = new JSONObject(getResponse.asString());
        User user=new ObjectMapper().readValue(String.valueOf(jsonObject.getJSONObject("data")), User.class);


        assertThat(user.getName(),is("test user"));
        assertThat(user.getEmail(),is("test@xyz1.com"));
        assertThat(user.getGender(),is("Male"));

deleteUserTest(user.getId());

    }


    public void deleteUserTest(Long userId) throws IOException {
        String apiPath="https://gorest.co.in/public-api/users/"+userId;

        Response getResponse = given()
                .contentType("application/json")
                .header("Authorization","Bearer e0c323fbe43d178075e0f9152edad4f14a7e0940cb880015e8e64240aa1bfda2")
                .when()
                .request(Method.DELETE, apiPath)
                .then()
                .extract()
                .response();
        assertThat(getResponse.getStatusCode(), is(HttpStatus.SC_OK));

    }



}
