package org.victoryw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ConsumerMain {

    @RequestMapping("/")
    public final @ResponseBody String hello() {
        return "Hello World";
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(ConsumerMain.class, args);
    }

}
