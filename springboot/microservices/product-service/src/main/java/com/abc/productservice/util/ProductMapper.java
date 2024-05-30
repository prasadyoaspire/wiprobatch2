package com.abc.productservice.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.productservice.entity.ProductEntity;
import com.abc.productservice.model.Product;

public class ProductMapper {

	public static ProductEntity mapToEntity(Product product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(product.getProductId());
		productEntity.setProductName(product.getProductName());
		productEntity.setProductPrice(product.getProductPrice());
		productEntity.setMfd(product.getMfd());
		productEntity.setCategory(product.getCategory());
		return productEntity;
	}

	public static Product mapToModel(ProductEntity productEntity) {
		Product product = new Product();
		product.setProductId(productEntity.getProductId());
		product.setProductName(productEntity.getProductName());
		product.setProductPrice(productEntity.getProductPrice());
		product.setMfd(productEntity.getMfd());
		product.setCategory(productEntity.getCategory());
		return product;
	}

	public static List<Product> mapToModelList(List<ProductEntity> productEntityList) {

		List<Product> productList = new ArrayList<>();

		for (ProductEntity entity : productEntityList) {
			Product product = new Product();
			product.setProductId(entity.getProductId());
			product.setProductName(entity.getProductName());
			product.setProductPrice(entity.getProductPrice());
			product.setMfd(entity.getMfd());
			product.setCategory(entity.getCategory());

			productList.add(product);
		}

		return productList;
	}

	public static List<ProductEntity> mapToEntityList(List<Product> productList) {

		List<ProductEntity> productEntityList = new ArrayList<>();

		for (Product product : productList) {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(product.getProductId());
			productEntity.setProductName(product.getProductName());
			productEntity.setProductPrice(product.getProductPrice());
			productEntity.setMfd(product.getMfd());
			productEntity.setCategory(product.getCategory());

			productEntityList.add(productEntity);
		}

		return productEntityList;
	}
}
