package com.poc.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageTranslatorFileRouter extends RouteBuilder {
    private static final String SOURCE_FOLDER = "data/input";
    private static final String DESTINATION_FOLDER = "data/outputAppendTransform";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?delete=false")
            .transform(body().append(header(Exchange.FILE_NAME)))
            .to("file://" + DESTINATION_FOLDER);
    }
}
