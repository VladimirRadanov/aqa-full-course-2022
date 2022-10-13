package test.components;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class RestFacade {

    private final CloseableHttpClient client = HttpClients.createDefault();

    public ClassicHttpRequest createGetRequest(String url) {
        return new HttpGet(url);
    }

    public Optional<HttpEntity> executeRequest(ClassicHttpRequest request) {
        try {
            return Optional.of(client.execute(request).getEntity());
        } catch (IOException e) {
            Assert.fail("failed to execute HTTP request");
        }
        return Optional.empty();
    }

    public void updateHeader(ClassicHttpRequest request, String headerName, String value) {
        request.addHeader(headerName, value);
    }
}
