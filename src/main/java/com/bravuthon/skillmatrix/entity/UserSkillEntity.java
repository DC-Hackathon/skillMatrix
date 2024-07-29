package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "user_skills")
public class UserSkillEntity extends BaseEntity {

    private UUID categoryId;
    private UUID skillId;
    private UUID productId;
    private String proficiencyLevel;
    private boolean certificateDone;
    private String upload;
    private boolean upSkill;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private UserEntity userId;

}
