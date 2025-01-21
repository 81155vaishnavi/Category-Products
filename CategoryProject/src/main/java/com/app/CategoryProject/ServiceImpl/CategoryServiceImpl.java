package com.app.CategoryProject.ServiceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.app.CategoryProject.Repository.CategoryRepository;
import com.app.CategoryProject.ServiceI.CategoryServiceI;
import com.app.CategoryProject.model.Category;
@Service
public class CategoryServiceImpl implements CategoryServiceI{
	
	@Autowired
	CategoryRepository cr;

	@Override
	public Category saveCategory(Category c) {
		Category save=cr.save(c);
		return c;
	}

	@Override
	public List<Category> GetAllData() {
		
		return cr.findAll();
	}

	@Override
	public Category GetSingleData(int id) {
		Optional<Category> categories=cr.findById(id);
		if(categories.isPresent())
		{
			Category category=categories.get();
			return category;
		}
		return null;
	}

	@Override
	public void DeleteData(int id) {
		
		cr.deleteById(id);
		
	}

	@Override
	public void editCategory(Category c, int id) {
		Category ca = cr.findById(id).get();

		if (null != ca) {
			ca.setId(c.getId());
			ca.setName(c.getName());
			ca.setUsername(c.getUsername());
			ca.setPassword(c.getPassword());
			
			cr.save(ca);
		} else {
			System.out.println("Data is not present");
		}

		
		
	}
		@Override
		public Page<Category> getPaginationCategory(int page, int size) {
			Pageable pageable = PageRequest.of(page, size);
	        return cr.findAll(pageable);
		
	}

}
