package com.example.testingweb;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    void doubleNumberShouldReturnDoubleFromService() throws Exception {
        int numberToDouble = 2;
        int expectedDouble = 4;
        when(service.doubleNumber(numberToDouble)).thenReturn(expectedDouble);
        this.mockMvc.perform(get("/double").param("number", String.valueOf(numberToDouble)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedDouble)));
    }
}