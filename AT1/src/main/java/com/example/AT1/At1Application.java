package com.example.AT1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class At1Application implements CommandLineRunner
{

	@Autowired
	RestTemplate restTemplate;
	public static void main(String[] args) {

		SpringApplication.run(At1Application.class, args);
	}
	@Override
	public void run(String... args) {

		String fooResourceUrl = "https://reqres.in/api/users?page={param1}";

		Map<String, String> vars = new HashMap<>();
		vars.put("param1", "2");

		String response = restTemplate.getForObject(fooResourceUrl, String.class, vars);


	}

}
