package com.app.CategoryProject.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.CategoryProject.Repository.ProductRepository;
import com.app.CategoryProject.ServiceI.ProductServiceI;
import com.app.CategoryProject.model.Category;
import com.app.CategoryProject.model.Product;
@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	ProductRepository pr;
	
	@Override
	public Product saveproduct(Product p) {
		Product save=pr.save(p);
		return p;
	}

	@Override
	public List<Product> GetAllData() {
		
		return pr.findAll();
	}

	@Override
	public Product GetSingleData(int id) {
		Optional<Product> products=pr.findById(id);
		if(products.isPresent())
		{
			Product product=products.get();
			return product;
		}
		return null;
	}

	@Override
	public void DeleteData(int id) {
		
		pr.deleteById(id);
		
	}

	@Override
	public void editProduct(Product p, int id) {
		Product pa = pr.findById(id).get();

		if (null != pa) {
			pa.setId(p.getId());
			pa.setName(p.getName());
			pa.setPrize(p.getPrize());
			pr.save(pa);
		} else {
			System.out.println("Data is not present");
		}

		
		
	}

	@Override
	public Page<Product> getPaginationProduct(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
        return pr.findAll(pageable);
	}

}
