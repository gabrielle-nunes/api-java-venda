package com.productapi.casadocodigo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapi.casadocodigo.dto.ProductDTO;
import com.productapi.casadocodigo.entities.Product;
import com.productapi.casadocodigo.repository.ProductRepositoy;

@Service
public class ProductService {

	@Autowired
	private ProductRepositoy productRepositoy;

	public List<ProductDTO> getAll() {
		List<Product> products = productRepositoy.findAll();
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	// retorna todos os produtos de uma determinada categoria
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepositoy.getProductByCategory(categoryId);
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	// retorna um produto para o id selecionado
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepositoy.findByProductIdentifier(productIdentifier);
		if (product != null) {
			return ProductDTO.convert(product);
		}
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		Product product = productRepositoy.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}

	public void delete(Long productId) {
		Optional<Product> product = productRepositoy.findById(productId);
		if(product.isPresent()) {
			productRepositoy.delete(product.get());
		}
	}
}