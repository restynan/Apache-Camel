package com.example.camel;

import org.apache.camel.builder.RouteBuilder;

public class HelloworldRoute extends RouteBuilder {
    public void configure() throws Exception {
        System.out.println("Hello world in Camel");
    }
}
