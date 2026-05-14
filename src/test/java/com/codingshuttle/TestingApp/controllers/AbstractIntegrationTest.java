package com.codingshuttle.TestingApp.controllers;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
public class AbstractIntegrationTest {

    @Autowired
    WebTestClient webTestClient;

    Employee testEmployee = new Employee(
            null,
            "anuj@gmail.com",
            "Anuj",
            200L,
            null
    );

    EmployeeDto testEmployeeDto = new EmployeeDto(
            null,
            "anuj@gmail.com",
            "Anuj",
            200L
    );
}