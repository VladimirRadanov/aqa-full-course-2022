package test.bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import test.dto.ResultsDto;
import test.main.util.DataHolder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public abstract class RestBaseSteps {

  protected final CloseableHttpClient restClient;
  private final ObjectMapper objectMapper;


  public RestBaseSteps() {
    restClient = HttpClients.createDefault();
    objectMapper = new ObjectMapper();
  }

  protected ResultsDto stringToObject(String input) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(input, ResultsDto.class);
  }

  protected String objectToString(Object input) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(input);
  }
}
