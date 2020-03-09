package com.errolitolopez.simplecrudapiforproducts.repository;

import com.errolitolopez.simplecrudapiforproducts.entity.ProductEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);
}
