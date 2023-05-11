package com.t3.springtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.t3.springtests.controller.MainController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringTestsApplicationTests {

	@Value(value = "${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private MainController mainController;

	@Test
	void contextLoads() {
		assertThat(mainController).isNotNull();
	}

	@Test
	public void mainPageTest() throws Exception {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Página Inicial");
	}

	@Test
	public void welcomeNoQuery() throws Exception {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/welcome", String.class)).contains("Hello World");
	}

	@Test
	public void welcomeWithQuery() throws Exception {
		String name = "Roger";
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/welcome?name=" + name, String.class)).contains("Hello " + name);

	}

}
