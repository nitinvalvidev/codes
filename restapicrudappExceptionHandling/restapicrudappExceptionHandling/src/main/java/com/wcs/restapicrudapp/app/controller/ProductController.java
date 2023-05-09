package com.wcs.restapicrudapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.restapicrudapp.app.exception.ProductNotFoundException;
import com.wcs.restapicrudapp.app.model.Product;

import com.wcs.restapicrudapp.app.service.ProductServiceI;

@RestController
public class ProductController {
	@Autowired
	ProductServiceI psi;

	@PostMapping(value = "/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
		
	return	new ResponseEntity<Product>(psi.saveProduct(p),HttpStatus.CREATED);//201
	}
	
	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> getAllproducts() {
		
		/*
		 * try { int a=10/0; } catch (Exception e) { return new
		 * ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR); }
		 */
			if(!psi.getAllproducts().isEmpty()) {
				return	new ResponseEntity<List<Product>>(psi.getAllproducts(),HttpStatus.OK);//200
			}
			else {
				return	new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);//404
			}
	
	}
	
	@DeleteMapping(value = "/product/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid) {
		psi.deleteProduct(pid);
		
		return new ResponseEntity<String>("record successfully deleted",HttpStatus.NO_CONTENT);//204
	}
	@PutMapping(value = "/product/{pid}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product p,@PathVariable int pid) {
		
		return new ResponseEntity<Product>(psi.updateProduct(pid,p),HttpStatus.OK);//200
		
	}
	
	@GetMapping(value = "/product/{productName}")
	public Product findByProductName(@PathVariable String productName)//http://localhost:9092/product/MI
	{
		//int a=10/0;
		Product p=null;
		//Exception handling in controller based approch
		/*
		 * try { p =psi.findByProductName(productName);
		 * System.out.println(p.getProductName()); } catch (Exception e) { throw new
		 * ProductNotFoundException("Product not Available"); } return p;
		 */
		
		return psi.findByProductName(productName);
	
	}
	// Exception handling in controller based approch
	
	/*
	 * @ExceptionHandler(ProductNotFoundException.class) public String
	 * productNotFoundExceptionHandler(ProductNotFoundException e) {
	 * System.out.println("exception handler method call"); return e.getMessage(); }
	 * 
	 * @ExceptionHandler(ArithmeticException.class) public String
	 * ArithmeticExceptionHandler(ArithmeticException e) {
	 * System.out.println("exception handler method call"); return e.getMessage(); }
	 */
	
}
