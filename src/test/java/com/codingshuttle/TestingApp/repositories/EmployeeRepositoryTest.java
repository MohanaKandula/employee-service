package com.codingshuttle.TestingApp.repositories;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {

        employee = new Employee(
                null,
                "abc@gmail.com",
                "John",
                50000L,
                null
        );
    }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {

        employeeRepository.save(employee);

        List<Employee> employeeList =
                employeeRepository.findByEmail(employee.getEmail());

        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail())
                .isEqualTo(employee.getEmail());
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList() {

        String email = "notPresent.123@gmail.com";

        List<Employee> employeeList =
                employeeRepository.findByEmail(email);

        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}