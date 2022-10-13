package test.bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.components.MyComponent;
import test.components.RestFacade;
import test.dto.PersonDto;
import test.dto.PersonNameDto;
import test.dto.ResultsDto;
import test.main.util.DataHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RestSteps extends RestBaseSteps {

    @Autowired
    private MyComponent myComponent;
    @Autowired
    private RestFacade restFacade;
    @Autowired
    private DataHolder dataHolder;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestSteps.class);

    private final static String RANDOM_USER_URL =
//            "https://randomuser.me/api/?inc=location,gender,name,nat&noinfo&gender=%s";
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=%s";

    private final static String CREATE_USER_URL =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=female";

    @Given("A random person {string} with gender {string}")
    public void createRandomPerson(String alias, String gender) throws IOException, ParseException {
        HttpGet getRequest = new HttpGet(String.format(RANDOM_USER_URL, gender));
        HttpEntity response = restClient.execute(getRequest).getEntity();
        dataHolder.put(alias, stringToObject(EntityUtils.toString(response)));
    }

    @When("i execute {string} request")
    public void createHttpRequest(String requestAlias) {
        restFacade.executeRequest(dataHolder.get(requestAlias, HttpGet.class))
                .ifPresent(httpEntity -> dataHolder.put(requestAlias, httpEntity));
    }

    @Given("i create a {string} request")
    public void iCreateARequest(String alias) {
        dataHolder.put(alias, restFacade.createGetRequest(CREATE_USER_URL));
    }

    @Then("response {string} contains {string}")
    public void responseContains(String responseAlias, String value) {
        ResultsDto dto = dataHolder.get(responseAlias, ResultsDto.class);
        LOGGER.debug("Evaluating result DTO {}", dto);
        assertThat(dto.getResults().get(0).getGender(), is(value));
    }

    @Given("request {string} has header {string} = {string}")
    public void updateRequest(String alias, String headerName, String value) {
        restFacade.updateHeader(dataHolder.get(alias, HttpGet.class), headerName, value);
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

        LOGGER.info("Print object {}", resultsDto);
    }
}
