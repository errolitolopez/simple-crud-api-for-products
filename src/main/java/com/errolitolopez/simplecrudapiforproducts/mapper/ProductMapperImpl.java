package com.errolitolopez.simplecrudapiforproducts.mapper;

import com.errolitolopez.simplecrudapiforproducts.entity.ProductEntity;
import com.errolitolopez.simplecrudapiforproducts.model.Product;
import com.errolitolopez.simplecrudapiforproducts.request.ProductForm;
import com.errolitolopez.simplecrudapiforproducts.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapEntityToModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setQuantity(productEntity.getQuantity());
        return product;
    }

    @Override
    public ProductEntity mapModelToEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setQuantity(product.getQuantity());
        return productEntity;
    }

    @Override
    public Product mapFormToModel(ProductForm productForm) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setQuantity(productForm.getQuantity());
        return product;
    }

    @Override
    public ProductResponse mapModelToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setQuantity(product.getQuantity());
        return productResponse;
    }
}
