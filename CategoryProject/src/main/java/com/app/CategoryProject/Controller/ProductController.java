package com.app.CategoryProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.CategoryProject.ServiceI.ProductServiceI;
import com.app.CategoryProject.model.Category;
import com.app.CategoryProject.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceI psi;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveCategory(@RequestBody Product c)
	{
		Product ca=psi.saveproduct(c);
		return new ResponseEntity<Product>(ca,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> GetAll()
	{
		List<Product> list=psi.GetAllData();
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getsingle(@PathVariable("id") int id)
	{
		Product pa=psi.GetSingleData(id);
		return new ResponseEntity<Product>(pa,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id")int id)
	{
		psi.DeleteData(id);
		return new ResponseEntity<String>("delete Data..",HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> updateData(@RequestBody Product p, @PathVariable("id") int id)

	{
		psi.editProduct(p, id);
		return new ResponseEntity<String>("Data updated", HttpStatus.CREATED);
	}
	
	@GetMapping("/Product/{page}/{size}")
    public List<Product> getPaginatedProduct(
    		@PathVariable int page,
    		@PathVariable int size) {
        return psi.getPaginationProduct(page, size).getContent();
    }


}
