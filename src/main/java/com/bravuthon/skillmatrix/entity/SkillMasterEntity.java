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
@Table(name= "skill_master")
public class SkillMasterEntity extends BaseEntity {

    @Column(name = "skill", nullable = false)
    private String skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", nullable = false)
    private CategoryMasterEntity categoryMasterEntity;

}
