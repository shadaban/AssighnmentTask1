package com.example.AT1.Service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Route to send birthday emails
        from("direct:birthday")
                .setHeader("subject", constant("Happy Birthday!"))
                .setBody(simple("Dear ${header.recipient},\n\nWishing you a very Happy Birthday!\n\nBest regards,\nYour Name"))
                .to("{{email.send}}");

        // Route to send anniversary emails
        from("direct:anniversary")
                .setHeader("subject", constant("Happy Anniversary!"))
                .setBody(simple("Dear ${header.recipient},\n\nWishing you a very Happy Anniversary!\n\nBest regards,\nYour Name"))
                .to("{{email.send}}");
    }
}
