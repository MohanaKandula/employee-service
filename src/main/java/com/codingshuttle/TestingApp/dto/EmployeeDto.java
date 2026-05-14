package com.codingshuttle.TestingApp.dto;

import java.util.Objects;

public class EmployeeDto {

    private Long id;
    private String email;
    private String fullName;
    private Long salary;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String email, String fullName, Long salary) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto that)) return false;

        return Objects.equals(id, that.id)
                && Objects.equals(email, that.email)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, fullName, salary);
    }
}