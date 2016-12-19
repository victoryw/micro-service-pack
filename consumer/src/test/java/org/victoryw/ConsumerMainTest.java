package org.victoryw;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by victoryw on 12/16/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConsumerMainTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;


    @Before
    public final void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public final void shouldReturnHelloWorldWhenRequest() throws Exception {
        this.mockMvc.perform(get("/")).
                andExpect(status().isOk());
    }

    @Test
    public final void shouldReturnHelloParamsWhenRequest() throws Exception {
        mockServer.expect(requestTo("http://provider.com/hello/wy"))
                .andExpect(method(GET))
                .andRespond(withSuccess(
                        "{\"result\":\"wy\"}",
                        MediaType.APPLICATION_JSON));

        this.mockMvc.perform(get("/hello/wy"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'result':'wy'}"));
        mockServer.verify();
    }
}
