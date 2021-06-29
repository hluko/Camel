package com.poc.camel.processor;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedFileRouter extends RouteBuilder {

    private static final String SOURCE_FOLDER = "data/input";
    private static final String DESTINATION_FOLDER_TXT = "data/outputTxtFile";
    private static final String DESTINATION_FOLDER_OTHER = "data/outputJsonFile";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?delete=true").choice()
            .when(simple("${file:ext} == 'txt'"))
            .to("file://" + DESTINATION_FOLDER_TXT).otherwise()
            .to("file://" + DESTINATION_FOLDER_OTHER);
    }
}
