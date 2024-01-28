package com.spring.test.mapper;

import com.spring.test.dto.ProductDto;
import com.spring.test.entity.Product;

public class ProductMapper {

	public static ProductDto mapToEmployeeDto(Product product) {
		return new ProductDto(
				product.getId(),
				product.getName(),
				product.getPrice(),
				product.getQuantity(),
				product.getCountryPro()
				);
	}
	
	public static Product mapToEmployee(ProductDto productDto) {
		return new Product(
				productDto.getId(),
				productDto.getName(),
				productDto.getPrice(),
				productDto.getQuantity(),
				productDto.getCountryPro()
				);
	}
}
