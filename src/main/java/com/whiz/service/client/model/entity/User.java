package com.whiz.service.client.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
}
