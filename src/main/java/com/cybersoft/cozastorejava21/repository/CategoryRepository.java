package com.cybersoft.cozastorejava21.repository;

import com.cybersoft.cozastorejava21.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

}
