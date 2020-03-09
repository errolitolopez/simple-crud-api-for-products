package com.errolitolopez.simplecrudapiforproducts.service;

import com.errolitolopez.simplecrudapiforproducts.request.ProductForm;
import com.errolitolopez.simplecrudapiforproducts.response.ProductResponse;
import java.util.List;

public interface ProductService {

    String createOrUpdateProduct(ProductForm productForm, Long id);

    ProductResponse findProductByName(String name);

    ProductResponse findProductById(Long id);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getAllProductsByDescription(String description);

    String deleteProductById(Long id);
}
