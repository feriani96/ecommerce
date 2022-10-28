package com.csf.ecommerce.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.csf.ecommerce.model.Product;
import com.csf.ecommerce.services.ProductServices;


//mark class as Controller  


@RestController 
//@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class ProductController {

	//autowire the BooksService class  
	@Autowired  
	ProductServices PS;  

	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/product")
	
	private List<Product> getAllProducts()   
	{  
		return PS.getAllProducts();  
	}  

	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/product/{productid}")  
	private Product getProducts(@PathVariable("productid") int productid)   
	{  
		return PS.getproductById(productid);  
	}  


	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/product/{productid}")  
	private void deleteRestaurant(@PathVariable("productid") int productid)   
	{  
		PS.delete(productid);  
	} 

	@PostMapping("/product")  
	private int saveRestaurant(@RequestBody Product p)   
	{  
		PS.saveOrUpdate(p);  
		return p.getId();  
	} 

	//creating put mapping that updates the book detail
	//@CrossOrigin(origins = "*")
	@PutMapping("/product")  
	private Product update(@RequestBody  Product p)   
	{  
		PS.saveOrUpdate(p);  
		return p;  
	}  
}