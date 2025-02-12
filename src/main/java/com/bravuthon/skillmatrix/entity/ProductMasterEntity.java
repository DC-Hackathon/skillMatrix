package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product_master")
public class ProductMasterEntity extends BaseEntity {

    private String productName;

    private String provider;

    @ManyToOne()
    @JoinColumn(name = "prod_id", nullable = false)
    private FunctionMasterEntity functionMasterEntity;


}
