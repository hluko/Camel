package com.poc.camel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.poc.camel.config.ContentBasedFileRouterConfig;

@SpringBootApplication
public class CamelApplication {

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ContentBasedFileRouterConfig.class);
        try {
            Thread.sleep(5000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }

}
