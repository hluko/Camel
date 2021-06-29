package com.poc.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    @Override
    public void process(final Exchange exchange) throws Exception {
        final String originalFileContent = exchange.getIn().getBody(String.class);
        final String upperCaseFileContent = originalFileContent.toUpperCase();
        exchange.getIn().setBody(upperCaseFileContent);
    }
}
