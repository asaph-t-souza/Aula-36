package com.t3.springtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.t3.springtests.controller.MainController;

@SpringBootTest
class SpringTestsApplicationTests {

	@Autowired
	private MainController mainController;

	@Test
	void contextLoads() {
		assertThat(mainController).isNotNull();
	}

}
