package bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.PersonDto;
import dto.PersonNameDto;
import dto.ResultsDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RestSteps extends RestBaseSteps {

    private final static String RANDOM_USER_URL =
//            "https://randomuser.me/api/?inc=location,gender,name,nat&noinfo&gender=%s";
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=%s";

    @Given("A random person {string} with gender {string}")
    public void createRandomPerson(String alias, String gender) throws IOException, ParseException {
        HttpGet getRequest = new HttpGet(String.format(RANDOM_USER_URL, gender));
        HttpEntity response = restClient.execute(getRequest).getEntity();
        dataHolder.put(alias, stringToObject(EntityUtils.toString(response)));
    }

    @When("i execute {string} request")
    public void createHttpRequest(String requestAlias) throws IOException, ParseException {
        CloseableHttpClient client = HttpClients.createDefault();
        ClassicHttpRequest request = dataHolder.get(requestAlias, HttpGet.class);
        HttpEntity entity = client.execute(request).getEntity();
        dataHolder.put(requestAlias, stringToObject(EntityUtils.toString(entity)));
    }

    @Given("i create a {string} request")
    public void iCreateARequest(String alias) {
        dataHolder.put(alias,
                new HttpGet("https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=female"));
    }

    @Given("request {string} has header {string} = {string}")
    public void updateRequest(String alias, String headerName, String value) {
        ClassicHttpRequest request = dataHolder.get(alias, HttpGet.class);
        request.addHeader(headerName, value);
    }

    @Then("response {string} contains {string}")
    public void responseContains(String responseAlias, String value) {
        assertThat(dataHolder.get(responseAlias, ResultsDto.class)
                .getResults().get(0).getGender(), is(value));
        System.out.println("tests complete!");
    }

    @Then("object to json step")
    public void objectToString() throws JsonProcessingException {

        List<PersonDto> persons = new ArrayList<>();
        PersonNameDto personOne = new PersonNameDto();
        personOne.setFirst("testFirst");
        personOne.setLast("testLast");
        personOne.setTitle("mrs");
        PersonDto person = new PersonDto();
        person.setName(personOne);
        person.setGender("female");
        person.setNat("Test");
        persons.add(person);

        ResultsDto resultsDto = new ResultsDto();
        resultsDto.setResults(persons);

        System.out.println(objectToString(resultsDto));
    }
}
