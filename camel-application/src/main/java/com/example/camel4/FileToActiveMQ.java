package com.example.camel4;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class FileToActiveMQ {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        context.addComponent("jms",  JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                System.out.println("bbbbbbbbbbbbmnh");
                from("file:input_box?noop=true")
                        .to("jms:queue:demo");
                System.out.println("bbbbbbbbbbbbmnhmmmmmmmmm");
            }
        });
        while(true)
        context.start();


    }
}