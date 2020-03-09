package com.errolitolopez.simplecrudapiforproducts.gateway;

import com.errolitolopez.simplecrudapiforproducts.entity.ProductEntity;
import com.errolitolopez.simplecrudapiforproducts.mapper.ProductMapper;
import com.errolitolopez.simplecrudapiforproducts.model.Product;
import com.errolitolopez.simplecrudapiforproducts.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductGatewayImpl implements ProductGateway {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void createOrUpdateProduct(Product product) {
        ProductEntity productEntity = productMapper.mapModelToEntity(product);
        productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Product product) {
        ProductEntity productEntity = productMapper.mapModelToEntity(product);
        productRepository.delete(productEntity);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepository.findByName(name)
                .map(productMapper::mapEntityToModel);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::mapEntityToModel);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapEntityToModel)
                .collect(Collectors.toList());
    }
}
