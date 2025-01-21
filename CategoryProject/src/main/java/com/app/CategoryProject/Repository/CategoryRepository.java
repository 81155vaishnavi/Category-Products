package com.app.CategoryProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.CategoryProject.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer>{

	
}
