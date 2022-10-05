package bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ResultsDto;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import main.util.DataHolder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public abstract class RestBaseSteps {

    protected final CloseableHttpClient restClient;
    protected DataHolder dataHolder = DataHolder.getInstance();
    private final ObjectMapper objectMapper;


    public RestBaseSteps() {
        restClient = HttpClients.createDefault();
        objectMapper = new ObjectMapper();
    }

    @Step("Convert string to object")
    protected ResultsDto stringToObject(String input) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(input, ResultsDto.class);
    }

    @Step("Convert object to string")
    protected String objectToString(Object input) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(input);
    }
}
