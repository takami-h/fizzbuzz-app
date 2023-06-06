package com.redhat.labs.fizzbuzz;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzbuzzApiApplicationIntegrationTest {
	@LocalServerPort int port;

	@BeforeEach void setup() {
		RestAssured.port = this.port;
	}

	@Test void shouldReturnFizz() {
		when()
			.get("/fizzbuzz/{number}", 3)
		.then()
			.statusCode(HttpStatus.OK.value())
			.body(equalTo("Fizz"));
	}

	@Test void shouldReturnBadRequest() {
		shouldReturnBadRequestIfPassed("foo");
		shouldReturnBadRequestIfPassed("0");
		shouldReturnBadRequestIfPassed("101");
	}

	private void shouldReturnBadRequestIfPassed(String param) {
		when()
			.get("/fizzbuzz/{number}", param)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
}
