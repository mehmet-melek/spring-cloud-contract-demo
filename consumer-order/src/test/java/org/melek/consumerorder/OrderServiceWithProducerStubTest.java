package org.melek.consumerorder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceWithProducerStubTest {

    @RegisterExtension
    static StubRunnerExtension stubRunnerExtension = new StubRunnerExtension()
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL)
            .downloadStub("org.melek", "producer-warehouse", "+", "stubs")
            .withPort(8081);

    private final OrderService orderService = new OrderService();
    private Order order;

    @Test
    void testCreateOrder_whenProductAndStockExist_shouldReturnOrderCreated() {
        order = new Order("ABC", 20);
        String result = orderService.createOrder(order);
        assertThat(result).contains("Order created");
    }

    @Test
    void testCreateOrder_whenProductIsNotExist_shouldReturnProductNotFoundMessage() {
        order = new Order("InvalidProduct", 20);
        String result = orderService.createOrder(order);
        assertThat(result)
                .contains("The order could not be created.")
                .contains("Product not found!");
    }

    @Test
    void testCreateOrder_whenProductIsExitButStockNotEnough_shouldReturnStockErrorMessage() {
        order = new Order("ABC", 50);
        String result = orderService.createOrder(order);
        assertThat(result)
                .contains("The order could not be created.")
                .contains("Not enough products were found!");
    }
}
