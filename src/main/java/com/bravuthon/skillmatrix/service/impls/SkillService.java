package com.bravuthon.skillmatrix.service.impls;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import com.bravuthon.skillmatrix.entity.SkillMasterEntity;
import com.bravuthon.skillmatrix.mapper.ProductMapper;
import com.bravuthon.skillmatrix.model.AddSkillRequest;
import com.bravuthon.skillmatrix.model.SkillResponse;
import com.bravuthon.skillmatrix.repository.CategoryRepo;
import com.bravuthon.skillmatrix.repository.SkillRepo;
import com.bravuthon.skillmatrix.service.SkillInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService implements SkillInf {

    private final SkillRepo skillRepo;
    private final CategoryRepo categoryRepo;

    @Autowired
    public SkillService(SkillRepo skillRepo, CategoryRepo categoryRepo) {
        this.skillRepo = skillRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public ResponseEntity<?> addSkill(AddSkillRequest addSkillRequest) {

        SkillResponse skillResponse = new SkillResponse();

        Optional<CategoryMasterEntity> byId = categoryRepo.findById(addSkillRequest.getCategoryId());
        if(byId.isPresent()) {
            SkillMasterEntity build = SkillMasterEntity.builder()
                .skill(addSkillRequest.getSkillName())
                .categoryMasterEntity(byId.get()).build();

            skillRepo.save(build);

            skillResponse.setSkillName(addSkillRequest.getSkillName());
            skillResponse.setCategoryName(byId.get().getCategoryName());

            return ResponseEntity.ok(skillResponse);
        }
        return ResponseEntity.noContent().build();
    }
}
