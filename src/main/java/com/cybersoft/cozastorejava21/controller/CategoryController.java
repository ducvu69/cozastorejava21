package com.cybersoft.cozastorejava21.controller;

import com.cybersoft.cozastorejava21.payload.response.BaseResponse;
import com.cybersoft.cozastorejava21.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("/clear-cache")
    @CacheEvict(value = "listCategory", allEntries = true)
    public ResponseEntity<?> clearCache(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(categoryServiceImp.getAllCategory());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
