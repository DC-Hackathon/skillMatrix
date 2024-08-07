package com.bravuthon.skillmatrix.service.impls;

import com.bravuthon.skillmatrix.entity.UserEntity;
import com.bravuthon.skillmatrix.entity.UserSkillEntity;
import com.bravuthon.skillmatrix.mapper.ProductMapper;
import com.bravuthon.skillmatrix.model.UserDto;
import com.bravuthon.skillmatrix.model.UserSkillRequest;
import com.bravuthon.skillmatrix.repository.UserRepo;
import com.bravuthon.skillmatrix.repository.UserSkillMasterRepo;
import com.bravuthon.skillmatrix.service.UserInf;
import com.bravuthon.skillmatrix.service.UserSkillInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserSkillImpl implements UserInf, UserSkillInf {

    private final UserRepo userRepo;
    private final ProductMapper userMapper;
    private final UserSkillMasterRepo userSkillMasterRepo;

    @Autowired
    public UserSkillImpl(UserRepo userRepo, ProductMapper userMapper, UserSkillMasterRepo userSkillMasterRepo) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.userSkillMasterRepo = userSkillMasterRepo;
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserEntity> userEntities = userRepo.findAll();
        if(userEntities.isEmpty()){
            ResponseEntity.notFound().build();
        }
        List<UserDto> list = userEntities.stream()
            .map(userMapper::userEntityToDto)
            .toList();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> getUser(UUID userId) {
        UserEntity userEntity = userRepo.findById(userId);
        if(userEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userEntityToDto(userEntity));
    }

    @Override
    public ResponseEntity<?> saveUserSkill(UserSkillRequest userSkillDto) {
        UserEntity userEntity = userRepo.findById(userSkillDto.getUserId());
        UserSkillEntity userSkill = new UserSkillEntity();
        userSkill.setSkillId(userSkillDto.getSkillId());
        userSkill.setUpSkill(userSkillDto.isUpSkill());
        userSkill.setProductId(userSkillDto.getProductId());
        userSkill.setCategoryId(userSkillDto.getCategoryId());
        userSkill.setCertificateDone(userSkillDto.isCertificateDone());
        userSkill.setProficiencyLevel(userSkillDto.getProficiencyLevel());
        userSkill.setUserEntity(userEntity);

        userSkillMasterRepo.save(userSkill);
        return ResponseEntity.ok(userSkillDto);
    }
}
