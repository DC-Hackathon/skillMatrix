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
public class UserSkillDto implements Serializable {

    private UUID id;
    private String categoryId;
    private String skillId;
    private String productId;
    private String proficiencyLevel;
    private boolean certificateDone;
    private String upload;
    private boolean upSkill;
    private UUID userId;
}
