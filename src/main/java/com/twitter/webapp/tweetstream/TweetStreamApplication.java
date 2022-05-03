package com.twitter.webapp.tweetstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.twitter.webapp")
public class TweetStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetStreamApplication.class, args);
	}

}
