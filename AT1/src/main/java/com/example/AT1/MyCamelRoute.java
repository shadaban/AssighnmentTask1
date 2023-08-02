package com.example.AT1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .setHeader("pageNo", simple("2"))
                .setHeader("ids", simple("7,8"))
                .to("direct:fetchData")
                .split().jsonpath("$.data[?(@.id in ${headers.ids})]")
                .marshal().json()
                .log("Filtered Output: ${body}");

        from("direct:fetchData")
                .setHeader("Accept", constant("application/json"))
                .to("https://reqres.in/api/users?page=${headers.pageNo}")
                .convertBodyTo(String.class);
    }
}
