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
public class AddSkillRequest implements Serializable {

    @NonNull
    private String skillName;

    @NonNull
    private UUID categoryId;
}
