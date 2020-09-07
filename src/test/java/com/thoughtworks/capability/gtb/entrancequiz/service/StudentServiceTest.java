package com.thoughtworks.capability.gtb.entrancequiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class StudentServiceTest {
    @Autowired
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void should_initial_student_list(){

    }
}
