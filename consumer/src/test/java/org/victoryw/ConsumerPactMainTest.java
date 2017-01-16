package org.victoryw;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by victoryw on 12/21/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyConfiguration.class,
        loader = AnnotationConfigContextLoader.class)
public class ConsumerPactMainTest {
    private final int successStatus = 200;

    private final int port = 8080;
    @Rule
    public final PactProviderRule provider = new PactProviderRule(
            "test_provider", "127.0.0.1",
            port, this);

    @Pact(provider = "test_provider", consumer = "test_consumer")
    public final PactFragment createFragment(
            final PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder
                .given("test state")
                .uponReceiving("example")
                .path("/hello/wy")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(successStatus)
                .body("{\"result\":\"wy\"}")
                .toFragment();
    }

    @Test
    @PactVerification("test_provider")
    public final void shouldReturnHelloParamsWhenRequest() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/hello/wy";

        ParameterizedTypeReference<ProviderResult> responseType;
        responseType = new ParameterizedTypeReference<ProviderResult>() {

        };
        ProviderResult body = restTemplate
                .exchange(url, HttpMethod.GET, null, responseType)
                .getBody();


        Assert.assertEquals(body.getResult(), "wy");
    }
}
