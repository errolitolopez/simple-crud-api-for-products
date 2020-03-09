package com.errolitolopez.simplecrudapiforproducts.service;

import com.errolitolopez.simplecrudapiforproducts.gateway.ProductGateway;
import com.errolitolopez.simplecrudapiforproducts.mapper.ProductMapper;
import com.errolitolopez.simplecrudapiforproducts.model.Product;
import com.errolitolopez.simplecrudapiforproducts.request.ProductForm;
import com.errolitolopez.simplecrudapiforproducts.response.ProductResponse;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductGateway productGateway;

    @Override
    public String createOrUpdateProduct(ProductForm productForm, Long id) {
        Product product = productMapper.mapFormToModel(productForm);

        Optional<Product> productFindByName = productGateway
                .findProductByName(productForm.getName());

        if (id == null) {
            if (productFindByName.isPresent()) {
                throw new RuntimeException("unable_to_create_product_already_exists");
            }

            productGateway.createOrUpdateProduct(product);
            return "product_created_successfully";
        }

        if (productFindByName.isPresent() && !productFindByName.get().getId().equals(id)) {
            throw new RuntimeException("unable_to_update_product_already_exists");
        }

        product.setId(id);
        productGateway.createOrUpdateProduct(product);
        return "product_updated_successfully";
    }

    @Override
    public String deleteProductById(Long id) {
        Product product = productGateway.findProductById(id)
                .orElseThrow(() -> new RuntimeException("unable_to_delete_product_does_not_exists"));

        productGateway.deleteProduct(product);
        return "product_deleted_successfully";
    }

    @Override
    public ProductResponse findProductByName(String name) {
        return productGateway.findProductByName(name)
                .map(productMapper::mapModelToResponse)
                .orElseThrow(() -> new RuntimeException("unable_to_find_product_does_not_exists"));
    }

    @Override
    public ProductResponse findProductById(Long id) {
        return productGateway.findProductById(id)
                .map(productMapper::mapModelToResponse)
                .orElseThrow(() -> new RuntimeException("unable_to_find_product_does_not_exists"));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productGateway.getAllProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .map(productMapper::mapModelToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getAllProductsByDescription(String description) {
        return productGateway.getAllProducts()
                .stream()
                .filter(product -> product.getDescription().equalsIgnoreCase(description))
                .sorted(Comparator.comparing(Product::getName))
                .map(productMapper::mapModelToResponse)
                .collect(Collectors.toList());
    }
}
