package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.model.FunctionMasterDto;
import com.bravuthon.skillmatrix.service.FunctionInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/pub/function")
public class FunctionController {

    private final FunctionInf functionInf;

    @Autowired
    public FunctionController(FunctionInf functionInf) {
        this.functionInf = functionInf;
    }

    @GetMapping(value = "/getAllFunction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FunctionMasterDto>> getAllFunction() {
        return functionInf.getAllFunctions();
    }

    @GetMapping(value = "/getFunction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionMasterDto> getFunction(UUID fId) {
        return functionInf.getFunctionById(fId);
    }
}
