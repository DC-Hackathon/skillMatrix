package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FunctionMatrix")
public class FunctionMaster extends BaseEntity {

    @Column(name = "function_name")
    private String functionName;
}
