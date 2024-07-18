package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name= "skill_master")
public class SkillMaster extends BaseEntity {

    @Column(name = "skill")
    private String skill;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private CategoryMaster categoryMaster;

}
