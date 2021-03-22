package com.lpg.prodmangsys.service;

import com.lpg.prodmangsys.dto.product.ProductResponseDtoMapper;
import com.lpg.prodmangsys.exception.ProductNotFoundException;
import com.lpg.prodmangsys.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductResponseDtoMapper productResponseDtoMapper;


    @Test
    void fails_when_products_are_not_found(){
        UUID uuid = UUID.randomUUID();
        given(productRepository.findById(uuid)).willReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.findById(uuid));
    }
}
