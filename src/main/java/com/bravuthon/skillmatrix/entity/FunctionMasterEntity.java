package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Function_master")
public class FunctionMasterEntity extends BaseEntity {

    @Column(name = "function_name")
    private String functionName;

    @OneToMany(mappedBy = "functionMasterEntity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ProductMasterEntity> productMasterEntity;
}
