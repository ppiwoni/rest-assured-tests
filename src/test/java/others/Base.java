package others;

import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;

public class Base {


    @BeforeTest
    protected void setup()
    {
        baseURI = "https://api.github.com";
    }

}
