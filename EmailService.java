package com.example.AT1.Service;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private final CamelContext camelContext;
    private final ProducerTemplate producerTemplate;

    public EmailService(CamelContext camelContext, ProducerTemplate producerTemplate) {
        this.camelContext = camelContext;
        this.producerTemplate = producerTemplate;
    }

    public void sendBirthdayEmails(List<String> recipients) {
        recipients.forEach(recipient -> {
            camelContext.createProducerTemplate().sendBodyAndHeader("direct:birthday", "", "recipient", recipient);
        });
    }

    public void sendAnniversaryEmails(List<String> recipients) {
        recipients.forEach(recipient -> {
            camelContext.createProducerTemplate().sendBodyAndHeader("direct:anniversary", "", "recipient", recipient);
        });
    }
}
