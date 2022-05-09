package com.twitter.webapp.tweetstream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class HomeController {

	@Value("${producer.host}")
	private String producerHost;
	@Value("${producer.relativePath}")
	private String relativePath;

    @GetMapping("/home")
    public String home(Model model) {
        return "tweet";
    }

    @GetMapping("/streamTweets")
    public void streamTweets(@RequestParam String ruleFilter) {

        final String uri = producerHost.concat(relativePath).concat(ruleFilter);
        RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(uri, String.class);
    }
}
