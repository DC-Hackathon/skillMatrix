package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.AddSkillRequest;
import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import com.bravuthon.skillmatrix.model.SkillResponse;
import org.springframework.http.ResponseEntity;

public interface SkillInf {

    ResponseEntity<?> addSkill(AddSkillRequest addSkillRequest);

}
