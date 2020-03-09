package com.errolitolopez.simplecrudapiforproducts.controller;

import com.errolitolopez.simplecrudapiforproducts.request.ProductForm;
import com.errolitolopez.simplecrudapiforproducts.response.ProductResponse;
import com.errolitolopez.simplecrudapiforproducts.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public String createProduct(@Valid @RequestBody ProductForm productForm) {
        return productService.createOrUpdateProduct(productForm, null);
    }

    @GetMapping(value = "/{name}")
    public ProductResponse findProductByName(@PathVariable(name = "name") String name) {
        return productService.findProductByName(name);
    }

    @PutMapping
    public String updateProduct(
            @RequestParam(name = "id") Long id,
            @Valid @RequestBody ProductForm productForm
    ) {
        return productService.createOrUpdateProduct(productForm, id);
    }

    @GetMapping
    public ProductResponse findProductById(@RequestParam(name = "id") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping(value = "/all")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/all/{description}")
    public List<ProductResponse> getAllProductsByDescription(@PathVariable String description) {
        return productService.getAllProductsByDescription(description);
    }

    @DeleteMapping
    public String deleteProductById(@RequestParam(name = "id") Long id) {
        return productService.deleteProductById(id);
    }
}
