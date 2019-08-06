package com.qatrainer.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qatrainer.core.model.QALink;
import com.qatrainer.core.service.TestService;

@Service
public class TestServiceImpl implements TestService {

//	@Value("${spring.jpa.properties.hibernate.dialect:Not fount}")
	@Value("${application.message:Not fount}")
	private String message;
	
	@Override
	public QALink getLink() {
		QALink link = new QALink();
		link.setId(1);
		link.setName("Test link: " + message);
		link.setUrl("http://google.pl");
		return link;
	}

}
