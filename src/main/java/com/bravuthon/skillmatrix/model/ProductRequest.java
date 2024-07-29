package com.bravuthon.skillmatrix.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest implements Serializable {

    private UUID functionId;

    private String productName;

    private String provider;
}
