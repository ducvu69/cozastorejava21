package com.cybersoft.cozastorejava21.service;

import com.cybersoft.cozastorejava21.entity.CategoryEntity;
import com.cybersoft.cozastorejava21.payload.response.CategoryRespone;
import com.cybersoft.cozastorejava21.repository.CategoryRepository;
import com.cybersoft.cozastorejava21.service.imp.CategoryServiceImp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    // @Cacheable("listCategory")
    public List<CategoryRespone> getAllCategory() {
        System.out.println("Kiểm tra category");
        List<CategoryRespone> responeList = new ArrayList<>();
        if (redisTemplate.hasKey("listCategory")) {
            System.out.println("Có giá trị trên redis");
            // Nếu như có thì lấy giá trị lưu trữ trên redis
            String data = redisTemplate.opsForValue().get("listCategory").toString();
            Type listType = new TypeToken<ArrayList<CategoryRespone>>(){}.getType();
            responeList = new Gson().fromJson(data, listType);
        } else {
            List<CategoryEntity> list = categoryRepository.findAll();
            for (CategoryEntity data : list) {
                CategoryRespone categoryRespone = new CategoryRespone();
                categoryRespone.setId(data.getId());
                categoryRespone.setName(data.getName());

                responeList.add(categoryRespone);
            }
        }
        Gson gson = new Gson();
        String data = gson.toJson(responeList);

        redisTemplate.opsForValue().set("listCategory", data);
        return responeList;
    }
}
