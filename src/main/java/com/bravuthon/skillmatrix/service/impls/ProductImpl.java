package com.bravuthon.skillmatrix.service.impls;

import com.bravuthon.skillmatrix.entity.FunctionMasterEntity;
import com.bravuthon.skillmatrix.entity.ProductMasterEntity;
import com.bravuthon.skillmatrix.model.ProductRequest;
import com.bravuthon.skillmatrix.repository.FunctionRepo;
import com.bravuthon.skillmatrix.repository.ProductRepo;
import com.bravuthon.skillmatrix.service.ProductInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductImpl implements ProductInf {

    private final ProductRepo productRepo;
    private final FunctionRepo functionRepo;

    @Autowired
    public ProductImpl(ProductRepo productRepo, FunctionRepo functionRepo) {
        this.productRepo = productRepo;
        this.functionRepo = functionRepo;
    }

    @Override
    public ResponseEntity<?> saveProduct(ProductRequest productRequest) {
        Optional<FunctionMasterEntity> function = functionRepo.findById(productRequest.getFunctionId());
        if(function.isPresent()){
            ProductMasterEntity productMasterEntity = new ProductMasterEntity();
            productMasterEntity.setProductName(productRequest.getProductName());
            productMasterEntity.setProvider(productRequest.getProvider());
            productMasterEntity.setFunctionMasterEntity(function.get());

            productRepo.save(productMasterEntity);

            return ResponseEntity.ok("Product saved");
        }
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<?> getAllProduct() {
        List<ProductMasterEntity> productRepoAll = productRepo.findAll();
        if(productRepoAll.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productRepoAll);
    }

    @Override
    public ResponseEntity<?> updateProduct(UUID id) {
        ProductMasterEntity byId = productRepo.getById(id);
        byId.setProductName(byId.getProductName()+"shdkadka");
        productRepo.save(byId);
        return ResponseEntity.ok("Product updated");
    }
}
