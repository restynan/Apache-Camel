package com.example.camel3;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.sql.SQLOutput;

public class producerandconsumer {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("direct:start")
                        .process(new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                String message=  exchange.getIn().getBody(String.class);
                                message=message+" -By Resty Nasimbwa ";
                                exchange.getOut().setBody(message);

                            }
                        })
                        .to("seda:end");

            }
        });
        context.start();

        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:start","Hello EveryOne");

        ConsumerTemplate consumerTemplate=context.createConsumerTemplate();
        String message = consumerTemplate.receiveBody("seda:end",String.class);
        System.out.println(message);






















    }
}
