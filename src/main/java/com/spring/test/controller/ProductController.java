package com.spring.test.controller;

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

import com.spring.test.dto.ProductDto;
import com.spring.test.entity.Product;
import com.spring.test.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {

	
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<ProductDto> AddProduct(@RequestBody ProductDto productDto){
		
		ProductDto savedProduct = productService.craeteProduct(productDto);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long productId){
		
		ProductDto productDto = productService.getProductById(productId);
		return ResponseEntity.ok(productDto);
	}
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductDto>>getAllProducts(){
		List<ProductDto>products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto>updateProduct(@PathVariable("id") Long productId ,@RequestBody ProductDto updateProduct){
	ProductDto productDto= 	productService.updateProduct(productId, updateProduct);
		return ResponseEntity.ok(productDto);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
		productService.deleteProduct(productId);
		return ResponseEntity.ok("Product deleted Successfully");
	}
	}
