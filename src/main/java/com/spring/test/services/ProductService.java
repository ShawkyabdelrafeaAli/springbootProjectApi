package com.spring.test.services;

import java.util.List;

import com.spring.test.dto.ProductDto;

public interface ProductService {

	ProductDto craeteProduct(ProductDto productDto);
	ProductDto getProductById(Long productId);
	List<ProductDto>getAllProducts();
	ProductDto updateProduct(Long productId ,ProductDto updateProduct);
	void deleteProduct(Long productId);
}
