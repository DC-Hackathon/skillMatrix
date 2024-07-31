package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.model.UserSkillDto;
import com.bravuthon.skillmatrix.model.UserSkillRequest;
import com.bravuthon.skillmatrix.repository.UserSkillMasterRepo;
import com.bravuthon.skillmatrix.service.SkillInf;
import com.bravuthon.skillmatrix.service.impls.UserSkillImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userSkill")
public class UserSkillMappingController {

    private final UserSkillImpl userSkill;

    public UserSkillMappingController(UserSkillImpl userSkill) {
        this.userSkill = userSkill;
    }


    @PostMapping(value = "/userMap", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mapUser(@RequestBody UserSkillRequest userSkillDto){
        return userSkill.saveUserSkill(userSkillDto);
    }

}
