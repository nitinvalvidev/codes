package com.wcs.restapicrudapp.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wcs.restapicrudapp.app.exception.ProductNotFoundException;
import com.wcs.restapicrudapp.app.model.Product;
import com.wcs.restapicrudapp.app.repositary.ProductRepo;
@Service
public class ProductServiceImpl implements ProductServiceI{
    
	@Autowired
	ProductRepo ps;
	
	@Override
	public Product saveProduct(Product p) {
		return ps.save(p);
	}

	@Override
	public Product findByProductName(String productName) {
		
		Product p=null;
		
		  try { 
			  p =ps.findByProductName(productName);
		  System.out.println(p.getProductName()); 
		  } catch (Exception e)
		  { 
			  throw new
		  ProductNotFoundException("Product not Available"); }
		  return p;
		 

	}

	@Override
	public List<Product> getAllproducts() {
		
		return ps.findAll();
	}

	@Override
	public void deleteProduct(int pid) {

		ps.deleteById(pid);
	}

	@Override
	public Product updateProduct(int pid, Product p) {
			p.setPid(pid);
		return	ps.save(p);
		
	}

}
