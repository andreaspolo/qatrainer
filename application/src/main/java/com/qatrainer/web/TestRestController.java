package com.qatrainer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qatrainer.core.model.Link;

@RestController(value = "/testapi")
public class TestRestController {

	@RequestMapping(value = "/link", method = RequestMethod.GET )
	public Link getLink() {
		Link testLink = new Link();
		testLink.setId(2);
		testLink.setName("Test Link");
		testLink.setUrl("http://google.pl");
		return testLink;
	}
}
