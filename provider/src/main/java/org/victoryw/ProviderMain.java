package org.victoryw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public final class ProviderMain {
    private ProviderMain() {
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(ProviderMain.class, args);
    }

}
