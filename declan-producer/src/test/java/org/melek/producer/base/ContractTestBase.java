package org.melek.producer.base;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.melek.producer.controller.DeclanController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContractTestBase {

    @BeforeAll
    void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(DeclanController.class);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }


}
