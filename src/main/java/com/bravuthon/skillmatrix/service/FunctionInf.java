package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.FunctionMasterDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface FunctionInf {
    ResponseEntity<FunctionMasterDto> getFunctionById(UUID fId);

    ResponseEntity<List<FunctionMasterDto>> getAllFunctions();

    ResponseEntity<?> createFunction(List<String> functions);
}
