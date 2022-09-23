package bdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.io.IOException;
import java.util.List;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;


public class RestSteps extends BaseStep {

  @Given("a new user request")
  public void getNewUser() {
    RestAssured
        .given()
        .queryParam("inc", List.of("name,gender,nat"))
        .queryParam("noinfo")
        .queryParam("gender", "female")
        .get("https://randomuser.me/api/")
        .then()
        .assertThat()
        .body(containsString("female"))
        .statusCode(200)
        .contentType(ContentType.JSON);
  }

  @Given("an Http client {string}")
  public void apacheHttpCall(String client) {
    dataHolder.put(client, HttpClients.createDefault());
  }

  @When("i execute {string} request with {string} as {string}")
  public void createHttpRequest(String requestAlias, String clientName, String responseAlias)
      throws IOException, ParseException {
    CloseableHttpClient client = (CloseableHttpClient) dataHolder.get(clientName);
    ClassicHttpRequest request = (ClassicHttpRequest) dataHolder.get(requestAlias);
    HttpEntity entity = client.execute(request).getEntity();
    dataHolder.put(responseAlias, EntityUtils.toString(entity));
  }

  @When("i create a {string} request")
  public void iCreateARequest(String alias) {
    dataHolder.put(alias,
        new HttpGet("https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=female"));
  }

  @When("request {string} has header {string} = {string}")
  public void updateRequest(String alias, String headerName, String value) {
    ClassicHttpRequest request = (ClassicHttpRequest) dataHolder.get(alias);
    request.addHeader(headerName, value);
    dataHolder.put(alias, request);
  }

  @Then("response {string} contains {string}")
  public void responseContains(String responseAlias, String value) {
    assertThat((String) dataHolder.get(responseAlias), containsString(value));
  }
}
