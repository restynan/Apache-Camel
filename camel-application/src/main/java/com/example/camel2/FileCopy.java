package com.example.camel2;

import com.example.camel.HelloworldRoute;
import org.apache.camel.CamelContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopy {
    public static void main(String[] args)  {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                public void configure() throws Exception {
                   from("file:data/input?noop=true")
                .to("file:data/output");

                }
            });

            context.start();
            Thread.sleep(5000);
            context.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
