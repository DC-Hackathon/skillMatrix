package com.bravuthon.skillmatrix.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(description = "Product Master DTO")
public class ProductMasterDto implements Serializable {
    private static final Long SERIAL_VERSION_ID = 1L;

    private  UUID id;

    private String productName;

    private String provider;

    private UUID functionMaster;
}
