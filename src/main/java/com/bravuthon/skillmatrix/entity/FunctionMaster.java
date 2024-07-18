package com.bravuthon.skillmatrix.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "FunctionMatrix")
public class FunctionMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "function_name")
    private String functionName;
}
