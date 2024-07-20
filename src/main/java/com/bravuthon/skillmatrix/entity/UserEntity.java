package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<UserSkillEntity> userSkillEntities;

}
