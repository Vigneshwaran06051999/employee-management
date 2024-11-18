package com.tahr.employee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Document
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private Integer id;
    @NonNull
    private String name;
    private String email;
    private String department;
    @NonNull
    private int salary;
    @NonNull
    private int number;
}
