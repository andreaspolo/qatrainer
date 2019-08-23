package com.qatrainer.core.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qatrainer.core.model.Answer;
import com.qatrainer.core.model.Category;
import com.qatrainer.core.model.Link;
import com.qatrainer.core.model.Principal;
import com.qatrainer.core.model.Question;
import com.qatrainer.core.model.Result;
import com.qatrainer.core.model.Training;
import com.qatrainer.core.model.User;
import com.qatrainer.core.service.TestService;


@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	private EntityManager em;
	
	@Value("${application.message:Not fount}")
	private String message;
	
	@Override
	public Link getLink() {
		
		test();
		
		Link link = new Link();
		link.setId(1);
		link.setName("Test link: " + message);
		link.setUrl("http://google.pl");
		return link;
	}

	
	private void test() {
		
		Question question = new Question();
		question.setText("Question");
		
		Answer answer1 = new Answer();
		answer1.setText("ANSWER_1");
		answer1.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setText("ANSWER_2");
		answer2.setQuestion(question);
		answer2.setCorrect(true);
		
		Answer answer3 = new Answer();
		answer3.setText("ANSWER_3");
		answer3.setQuestion(question);
		
		Link link1 = new Link();
		link1.setName("LINK 1");
		link1.setUrl("URL1");
		
		Link link2 = new Link();
		link2.setName("LINK 2");
		link2.setUrl("URL2");
		
		Principal principal1 = new Principal();
		principal1.setName("PRINCIPAL_1");
		
		Principal principal2 = new Principal();
		principal2.setName("PRINCIPAL_2");
		
		Category category = new Category();
		category.setName("CATEGORY 1");
		category.setDescription("DESC CAT 1");
		category.getPrincipals().add(principal1);
		category.getPrincipals().add(principal2);
		
		question.getAnswers().add(answer1);
		question.getAnswers().add(answer2);
		question.getAnswers().add(answer3);
		
		question.getLinks().add(link1);
		question.getLinks().add(link2);
		
		question.getCategories().add(category);
		
		
		User user = new User();
		user.setName("USER");
		user.setUsername("username");
		user.setPassword("pass");
		user.getPrincipals().add(principal2);
		
		em.persist(user);
		em.flush();
		em.persist(question);
		
		Training training = new Training();
		training.setName("TRAINING");
		training.setDescription("DESC TRAINING");
		training.setAuthor(user);
		training.getCategories().add(category);
		
		Result result1 = new Result();
		result1.setComplete(true);
		result1.setTraining(training);
		result1.setUser(user);
		
		Result result2 = new Result();
		result2.setTraining(training);
		result2.setUser(user);
		
		training.getResults().add(result1);
		training.getResults().add(result2);
		
		em.flush();
		em.persist(training);
	}
}
