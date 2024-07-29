package com.bravuthon.skillmatrix.service.impls;

import com.bravuthon.skillmatrix.entity.FunctionMasterEntity;
import com.bravuthon.skillmatrix.mapper.FunctionMapper;
import com.bravuthon.skillmatrix.model.FunctionMasterDto;
import com.bravuthon.skillmatrix.repository.FunctionRepo;
import com.bravuthon.skillmatrix.service.FunctionInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FunctionImpl implements FunctionInf {

    private final FunctionRepo functionRepo;
    private final FunctionMapper functionMapper;

    @Autowired
    public FunctionImpl(FunctionRepo functionRepo, FunctionMapper functionMapper) {
        this.functionRepo = functionRepo;
        this.functionMapper = functionMapper;
    }

    @Override
    public ResponseEntity<FunctionMasterDto> getFunctionById(UUID fId) {
        Optional<FunctionMasterEntity> byId = functionRepo.findById(fId);
        return byId.map(functionMasterEntity -> ResponseEntity.ok(functionMapper.functionEntityToDto(functionMasterEntity)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<FunctionMasterDto> > getAllFunctions() {
        List<FunctionMasterDto> functionList = functionRepo.findAll()
            .stream()
            .map(functionMapper::functionEntityToDto)
            .toList();
        if(functionList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(functionList);
    }
}
