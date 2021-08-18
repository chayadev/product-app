package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;


@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<List<Product>>(repository.findAll(),HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
		return new ResponseEntity<>(repository.save(product),HttpStatus.CREATED);
	}
	

}