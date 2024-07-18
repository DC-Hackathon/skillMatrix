package com.bravuthon.skillmatrix.entity;

import com.bravuthon.skillmatrix.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name= "category_table")
public class CategoryMaster extends BaseEntity {

    @Column(name = "cat_id", nullable = false)
    private Long catId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "categoryMaster", fetch = FetchType.EAGER)
    private List<SkillMaster> skillMasterList;


}
