package com.spring.test.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.test.dto.ProductDto;
import com.spring.test.entity.Product;
import com.spring.test.exception.ResourseNotFonudException;
import com.spring.test.mapper.ProductMapper;
import com.spring.test.repository.ProductRepo;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{

	private ProductRepo productRepo;
	
	@Override
	public ProductDto craeteProduct(ProductDto productDto) {
		
		Product product = ProductMapper.mapToEmployee(productDto);
		Product SavedProduct = productRepo.save(product);
		return ProductMapper.mapToEmployeeDto(SavedProduct);
		
	}

	@Override
	public ProductDto getProductById(Long productId) {
		
		Product product = productRepo.findById(productId).orElseThrow(()-> new ResourseNotFonudException("this id nout found " + productId));
		return ProductMapper.mapToEmployeeDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products.stream().map((product)-> ProductMapper.mapToEmployeeDto(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto updateProduct(Long productId, ProductDto updateProduct) {
	 Product product =	productRepo.findById(productId).orElseThrow(
				()-> new ResourseNotFonudException("Product is not found"  +  productId));
		
	
	product.setName(updateProduct.getName());
	product.setPrice(updateProduct.getPrice());
	product.setQuantity(updateProduct.getQuantity());
	product.setCountryPro(updateProduct.getCountryPro());
	
	  Product updateProductObj =  productRepo.save(product);
	return ProductMapper.mapToEmployeeDto(updateProductObj);
	}

	@Override
	public void deleteProduct(Long productId) {
		 Product product =	productRepo.findById(productId).orElseThrow(
					()-> new ResourseNotFonudException("Product is not found"  +  productId));
	
		 productRepo.deleteById(productId);
	}	
	
}


