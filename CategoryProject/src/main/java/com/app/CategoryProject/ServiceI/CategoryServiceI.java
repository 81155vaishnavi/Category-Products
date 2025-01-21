package com.app.CategoryProject.ServiceI;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.CategoryProject.model.Category;

public interface CategoryServiceI {

	public Category saveCategory(Category c);

	public List<Category> GetAllData();

	public Category GetSingleData(int id);

	public void DeleteData(int id);

	public void editCategory(Category c, int id);

	public Page<Category> getPaginationCategory(int page, int size);

	

}
