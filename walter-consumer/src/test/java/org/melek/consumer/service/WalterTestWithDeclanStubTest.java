package org.melek.consumer.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DirtiesContext
@AutoConfigureStubRunner
        (
                stubsMode = StubRunnerProperties.StubsMode.LOCAL,
                ids = "org.melek:declan-producer:+:stubs:10010"
        )
@EnableStubRunnerServer
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalterTestWithDeclanStubTest {
/*    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("org.melek", "declan-producer", "0.0.1-SNAPSHOT", "stubs")
            .withPort(10010)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);*/

    private final static String BASE_URI = "http://localhost";

    @LocalServerPort
    private int port;


    @BeforeAll
    void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }

    @Test
    void sampleTest() {
        Response response = RestAssured.given()
                .params("name", "say-my-name")
                .when().get("/check");
        response.then().assertThat()
                .statusCode(200);
        BDDAssertions.assertThat(response.getBody().asString()).isEqualTo("Yee!");
    }

    @Test
    void sampleTest2() {
        Response response = RestAssured.given()
                .params("name", "some-dummy-words")
                .when().get("/check");
        response.then().assertThat()
                .statusCode(200);
        BDDAssertions.assertThat(response.getBody().asString()).isEqualTo("Noo!");
    }
}
