package com.bravuthon.skillmatrix.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryMasterDto implements Serializable {

    private static final Long SERIAL_VERSION_ID = 1L;

    private UUID id;

    private String categoryName;

    private String createdBy;

    private Date createdAt;

    private Set<SkillMasterDto> skillMasterSet;
}
