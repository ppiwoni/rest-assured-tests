package tests;

import DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import others.Base;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class UserTest extends Base {

    String user = "octocat";

    @Test
    public void getUser() {

        UserDTO retrievedUser = given()
                .pathParam("login",user)
        .when()
                .get("/users/{login}")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(1000L))
                .log().all()
                .extract().as(UserDTO.class);


        assertThat(retrievedUser.login).isEqualTo("octocat");
        assertThat(retrievedUser.id).isEqualTo(583231);
        assertThat(retrievedUser.url).contains("/users/octocat");
        assertThat(retrievedUser.type).isEqualTo("User");
        assertThat(retrievedUser.site_admin).isEqualTo(false);
        assertThat(retrievedUser.updated_at).contains("2021");
    }
}
