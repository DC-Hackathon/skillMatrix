package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.UserSkillDto;
import org.springframework.http.ResponseEntity;

public interface UserSkillInf {

    ResponseEntity<?> saveUserSkill(UserSkillDto userSkillDto);

}
