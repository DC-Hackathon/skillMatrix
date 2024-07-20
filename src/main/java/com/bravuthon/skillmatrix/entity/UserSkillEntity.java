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
@Table(name= "user_skills")
public class UserSkillEntity extends BaseEntity {

    private String name;
    private String categoryId;
    private String skillId;
    private String productId;
    private String proficiencyLevel;
    private boolean certificateDone;
    private String upload;
    private boolean upSkill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;
}
