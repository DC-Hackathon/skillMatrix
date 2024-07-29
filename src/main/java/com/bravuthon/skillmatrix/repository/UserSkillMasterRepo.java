package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillMasterRepo extends JpaRepository<UserSkillEntity, Object> {
}
