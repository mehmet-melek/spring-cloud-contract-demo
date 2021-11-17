package org.melek.producerwarehouse;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WarehouseControllerContactsBase {

    @BeforeAll
    void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(WarehouseController.class);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

}