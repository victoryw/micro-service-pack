package org.victoryw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
public class ConsumerMain {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public final
    @ResponseBody
    String hello() {
        return "Hello World";
    }


    @RequestMapping("/hello/{username}")
    public final
    @ResponseBody
    ProviderResult helloProvider(@PathVariable final String username) {
        String url = "http://provider.com/hello/" + username;
        ProviderResult result =
                restTemplate.getForObject(url, ProviderResult.class);
        return result;
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(ConsumerMain.class, args);
    }

}

