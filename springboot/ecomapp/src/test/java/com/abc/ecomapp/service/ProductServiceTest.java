package com.abc.ecomapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecomapp.entity.Product;
import com.abc.ecomapp.exception.ProductNotFoundException;
import com.abc.ecomapp.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	private ProductServiceImpl productService;
		
	@Mock
	private ProductRepository productRepository;
	
	@Test
	void testSaveProduct() {		
		Product product = new Product();
		product.setProductId(10);
		product.setProductName("ScanDesk");
		product.setProductPrice(2500);
		product.setMfd(LocalDate.of(2021, 10, 10));
		product.setCategory("Pendrive");
		
		when(productRepository.save(product)).thenReturn(product);
		
		Product newProduct = productService.saveProduct(product);			
		assertEquals("ScanDesk", newProduct.getProductName());		
	}	
	
	@Test
	void testFindProductById() {		
		Product product = new Product();
		product.setProductId(10);
		product.setProductName("ScanDesk");
		product.setProductPrice(2500);
		product.setMfd(LocalDate.of(2021, 10, 10));
		product.setCategory("Pendrive");
		
		when(productRepository.findById(10)).thenReturn(Optional.of(product));		
		
		Product p = productService.findProductById(10);
		
		assertEquals(product.getProductId(),p.getProductId());
		assertEquals(product.getProductName(),p.getProductName());		
	}
	
	
	@Test
	void testFindProductByIdWithException() {		
		int productId = 10;		
		when(productRepository.findById(productId)).thenThrow(ProductNotFoundException.class);		
		assertThrows(ProductNotFoundException.class , ()-> productService.findProductById(productId));
	}	
	
}
