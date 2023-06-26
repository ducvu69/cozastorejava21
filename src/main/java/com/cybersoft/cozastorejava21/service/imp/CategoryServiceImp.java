package com.cybersoft.cozastorejava21.service.imp;

import com.cybersoft.cozastorejava21.payload.response.CategoryRespone;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface CategoryServiceImp {
    List<CategoryRespone> getAllCategory();
}
