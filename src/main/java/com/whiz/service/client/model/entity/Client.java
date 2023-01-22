package com.whiz.service.client.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "Clients")
@Getter
@Setter
@Builder
public class Client {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String motherLastName;

    @Column
    private String paternalLastName;

    @Column
    private LocalDate dateBirth;

    @Column
    private LocalDateTime creationDateTime;

}
