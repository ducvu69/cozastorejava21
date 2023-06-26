package com.cybersoft.cozastorejava21.service;

import com.cybersoft.cozastorejava21.entity.CategoryEntity;
import com.cybersoft.cozastorejava21.payload.response.CategoryRespone;
import com.cybersoft.cozastorejava21.repository.CategoryRepository;
import com.cybersoft.cozastorejava21.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryRespone> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryRespone> responeList = new ArrayList<>();

        for (CategoryEntity data: list) {
            CategoryRespone categoryRespone = new CategoryRespone();
            categoryRespone.setId(data.getId());
            categoryRespone.setName(data.getName());

            responeList.add(categoryRespone);
        }
        return responeList;
    }
}
