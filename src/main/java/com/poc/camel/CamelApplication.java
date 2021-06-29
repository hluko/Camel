package com.poc.camel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.poc.camel.config.ContentBasedFileRouterConfig;

@SpringBootApplication
public class CamelApplication {

    public static void main(final String[] args) {
        // final ClassPathXmlApplicationContext applicationContext = new
        // ClassPathXmlApplicationContext("camel-context.xml");
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ContentBasedFileRouterConfig.class);
        try {
            Thread.sleep(5000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }

}
