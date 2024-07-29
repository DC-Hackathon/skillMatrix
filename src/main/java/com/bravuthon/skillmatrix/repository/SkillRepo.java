package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.SkillMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<SkillMasterEntity, Object> {

//    Optional<SkillMasterEntity> findById(UUID id);

}
