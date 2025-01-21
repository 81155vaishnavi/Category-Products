package com.app.CategoryProject.ServiceI;

import java.util.List;

import org.springframework.data.domain.Page;
import com.app.CategoryProject.model.Product;

public interface ProductServiceI {

	public Product saveproduct(Product c);

	public List<Product> GetAllData();

	public Product GetSingleData(int id);

	public void DeleteData(int id);

	public void editProduct(Product p, int id);

	public Page<Product> getPaginationProduct(int page, int size);


}
