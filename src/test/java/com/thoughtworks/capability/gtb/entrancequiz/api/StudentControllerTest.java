package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_return_student_list_when_request_for_all() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$",hasSize(35)))
                .andExpect(jsonPath("$.[34].id",is(35)))
                .andExpect(jsonPath("$.[34].name",is("凌凤仪")))
                .andExpect(status().isOk());

    }
}
