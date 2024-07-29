package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "user_master")
public class UserEntity extends BaseEntity {

    private String name;
    private String designation;
    private String role;
    private String function;
    private String managerName;
    private String experience;
    private String location;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    @PrimaryKeyJoinColumn
    private UserSkillEntity userSkillEntities;

}
