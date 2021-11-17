package org.melek.producerwarehouse.unit.controller;

import org.junit.jupiter.api.Test;
import org.melek.producerwarehouse.WarehouseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WarehouseController.class)
class WarehouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenProductAndStockIsValid_shouldReturnProductReserved() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/productReservation")
                .param("product","ABC")
                .param("quantity","20"))
                .andExpect(status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString().contains("Products are reserved"));
    }

    @Test
    void whenProductIsNotExist_shouldReturnProductNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/productReservation")
                        .param("product","InvalidProduct")
                        .param("quantity","20"))
                .andExpect(status().isNotFound())
                .andExpect(result -> result.getResponse().getContentAsString().contains("Product not found!"));
    }

    @Test
    void whenStockIsNotEnough_shouldReturnStockErrorMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/productReservation")
                        .param("product","ABC")
                        .param("quantity","50"))
                .andExpect(status().isNotFound())
                .andExpect(result -> result.getResponse().getContentAsString().contains("Not enough products were found!"));
    }


}
