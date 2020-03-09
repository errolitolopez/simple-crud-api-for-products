package com.errolitolopez.simplecrudapiforproducts.mapper;

import com.errolitolopez.simplecrudapiforproducts.entity.ProductEntity;
import com.errolitolopez.simplecrudapiforproducts.model.Product;
import com.errolitolopez.simplecrudapiforproducts.request.ProductForm;
import com.errolitolopez.simplecrudapiforproducts.response.ProductResponse;

public interface ProductMapper {

    Product mapEntityToModel(ProductEntity productEntity);

    ProductEntity mapModelToEntity(Product product);

    Product mapFormToModel(ProductForm productForm);

    ProductResponse mapModelToResponse(Product product);
}
