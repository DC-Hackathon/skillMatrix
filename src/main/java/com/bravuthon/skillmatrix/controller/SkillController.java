package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import com.bravuthon.skillmatrix.entity.SkillMasterEntity;
import com.bravuthon.skillmatrix.model.AddSkillRequest;
import com.bravuthon.skillmatrix.repository.CategoryRepo;
import com.bravuthon.skillmatrix.repository.SkillRepo;
import com.bravuthon.skillmatrix.service.SkillInf;
import com.bravuthon.skillmatrix.service.impls.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/pub/skill")
public class SkillController {

    private final SkillInf skillService;
    @Autowired
    public SkillController(SkillInf skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/getSkill")
    public ResponseEntity<?> getSkill(){
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/addSkill", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSkill(@RequestBody AddSkillRequest addSkillRequest) {
            return skillService.addSkill(addSkillRequest);
    }

}
