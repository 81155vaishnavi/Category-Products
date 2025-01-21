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

import com.app.CategoryProject.ServiceI.CategoryServiceI;
import com.app.CategoryProject.model.Category;
@RestController
@RequestMapping("/category")
public class HomeController {
	
	@Autowired
	CategoryServiceI csi;

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategory(@RequestBody Category c)
	{
		Category ca=csi.saveCategory(c);
		return new ResponseEntity<Category>(ca,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Category>> GetAll()
	{
		List<Category> list=csi.GetAllData();
		return new ResponseEntity<List<Category>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Category> getsingle(@PathVariable("id") int id)
	{
		Category ca=csi.GetSingleData(id);
		return new ResponseEntity<Category>(ca,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id")int id)
	{
		csi.DeleteData(id);
		return new ResponseEntity<String>("delete Data..",HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> updateData(@RequestBody Category c, @PathVariable("id") int id)

	{
		csi.editCategory(c, id);
		return new ResponseEntity<String>("Data updated", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/Category/{page}/{size}")
    public List<Category> getPaginatedCategory(
    		@PathVariable int page,
    		@PathVariable int size) {
        return csi.getPaginationCategory(page, size).getContent();
    }
	
}
