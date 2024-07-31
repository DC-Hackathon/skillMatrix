package com.bravuthon.skillmatrix.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto implements Serializable {

    private UUID id;
    private String name;
    private String designation;
    private String role;
    private String function;
    private String managerName;
    private String experience;
    private String location;
    private List<UserSkillDto> userSkillDto;

}
