package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "category_table")
public class CategoryMasterEntity extends BaseEntity {

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "categoryMasterEntity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<SkillMasterEntity> skillMasterEntitySet;


}
