package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.UserSkillDto;
import com.bravuthon.skillmatrix.model.UserSkillRequest;
import org.springframework.http.ResponseEntity;

public interface UserSkillInf {

    ResponseEntity<?> saveUserSkill(UserSkillRequest userSkillDto);

}
