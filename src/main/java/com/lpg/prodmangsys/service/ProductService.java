package com.lpg.prodmangsys.service;

import com.lpg.prodmangsys.dto.product.ProductRequestDto;
import com.lpg.prodmangsys.dto.product.ProductRequestDtoMapper;
import com.lpg.prodmangsys.dto.product.ProductResponseDto;
import com.lpg.prodmangsys.dto.product.ProductResponseDtoMapper;
import com.lpg.prodmangsys.entity.Product;
import com.lpg.prodmangsys.exception.ProductNotFoundException;
import com.lpg.prodmangsys.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductRequestDtoMapper productRequestDtoMapper;
    private final ProductResponseDtoMapper productResponseDtoMapper;


    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductRequestDtoMapper productRequestDtoMapper,
                          ProductResponseDtoMapper productResponseDtoMapper) {
        this.productRepository = productRepository;
        this.productRequestDtoMapper = productRequestDtoMapper;
        this.productResponseDtoMapper = productResponseDtoMapper;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product =  productRequestDtoMapper.toEntity(productRequestDto);
        Product createdProduct = productRepository.save(product);
        return productResponseDtoMapper.fromEntity(createdProduct);

    }

    public ProductResponseDto findById(UUID id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.map(productResponseDtoMapper::fromEntity).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<ProductResponseDto> findAll() {
        List<Product> listOfProducts = productRepository.findAll();
        return productResponseDtoMapper.fromEntityList(listOfProducts);
    }



    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, UUID id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        Product updatedProductInstance;
        if(foundProduct.isPresent()) {
            Product product = productRequestDtoMapper.toEntity(productRequestDto);
            updatedProductInstance = productRepository.save(product);
        }
        else throw new ProductNotFoundException(id);

        return productResponseDtoMapper.fromEntity(updatedProductInstance);
    }

    public ResponseEntity<Void> deleteProduct(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
        }
        return null;
    }


}
