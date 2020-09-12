package com.example.camelapacheseconddemo.route;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;



// Timer will be launched every 10s, and every time it lauches it is going to pull files from data/input
// from("timer://foo?delay=-1"   )
@Component
public class SimpleCamelRoute extends RouteBuilder {
    @Autowired
    Environment env;
    @Override
    public void configure() throws Exception {

                       //from("{{startRoute}}")
                       //
                       from("{{fromRoute}}")
                               .log("Timer Invoked and the body "+ env.getProperty("message"))
                       .to("{{toRoute1}}");
    }
}
