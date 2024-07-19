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
public class SkillMasterDto implements Serializable {

    private static final Long SERIAL_VERSION_ID = 1L;

    private UUID id;

    private String skill;

}
