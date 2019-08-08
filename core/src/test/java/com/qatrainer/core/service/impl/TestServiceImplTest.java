package com.qatrainer.core.service.impl;

import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qatrainer.core.model.Link;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnit44Runner.class)
public class TestServiceImplTest {

	
	@InjectMocks
	private TestServiceImpl testObj;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Link res = testObj.getLink();
		
		assertSame(1, res.getId());
	}

}
