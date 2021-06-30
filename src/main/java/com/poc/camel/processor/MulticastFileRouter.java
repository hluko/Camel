package com.poc.camel.processor;

import org.apache.camel.builder.RouteBuilder;

public class MulticastFileRouter extends RouteBuilder {
    private static final String SOURCE_FOLDER = "data/input";
    private static final String DESTINATION_FOLDER_WORLD = "data/outputAppendWorld";
    private static final String DESTINATION_FOLDER_HELLO = "data/outputAppendHello";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?delete=false")
            .multicast()
            .to("direct:append").end();

        from("direct:append")
            .transform(body().append("World"))
            .to("file://" + DESTINATION_FOLDER_WORLD);

        from("direct:prepend")
            .transform(body().prepend("Hello"))
            .to("file://" + DESTINATION_FOLDER_HELLO);
    }
}
