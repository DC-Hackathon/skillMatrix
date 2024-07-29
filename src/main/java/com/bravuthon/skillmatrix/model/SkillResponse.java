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
@Schema(description = "Skill Response")
public class SkillResponse implements Serializable {

    @NonNull
    private String skillName;

    @NonNull
    private String categoryName;
}
