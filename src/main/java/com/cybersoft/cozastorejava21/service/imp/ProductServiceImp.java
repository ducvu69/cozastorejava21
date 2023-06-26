package com.cybersoft.cozastorejava21.service.imp;

import com.cybersoft.cozastorejava21.payload.response.ProductResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);
}
