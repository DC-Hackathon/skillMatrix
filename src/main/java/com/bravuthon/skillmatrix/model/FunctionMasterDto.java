package com.bravuthon.skillmatrix.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(description = "Function Master DTO")
public class FunctionMasterDto implements Serializable {
    private static final Long SERIAL_VERSION_ID = 1L;

    private UUID id;

    private String functionName;

    private String createdBy;

    private Date createdAt;

    private List<ProductMasterDto> productMasterDtos;
}
