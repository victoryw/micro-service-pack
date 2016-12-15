package org.victoryw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by victoryw on 12/16/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConsumerMainTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_hello_world_when_call_the_hello_url() throws Exception {
        this.mockMvc.perform(get("/")).
                andExpect(status().isOk());
    }
}