package com.bravuthon.skillmatrix.model;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserSkillRequest {

    private UUID userId;
    private String categoryId;
    private String skillId;
    private String productId;
    private String proficiencyLevel;
    private boolean certificateDone;
    private String upload;
    private boolean upSkill;
}
