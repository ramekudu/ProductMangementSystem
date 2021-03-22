package com.lpg.prodmangsys.controller;

import com.lpg.prodmangsys.dto.product.ProductRequestDto;
import com.lpg.prodmangsys.dto.product.ProductResponseDto;
import com.lpg.prodmangsys.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private ProductRequestDto productRequestDto;

    @Test
    void get_product_returns_when_no_product_found(){
        ResponseEntity<ProductResponseDto> response = productController.getProductByIsbn(UUID.randomUUID());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void create_product_returns_success(){
        given(productService.createProduct(productRequestDto)).willReturn(new ProductResponseDto());
        ResponseEntity<ProductResponseDto> response = productController.createProduct(productRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void get_product_returns_when_product_found(){
        UUID uuid = UUID.randomUUID();
        given(productService.findById(uuid)).willReturn(new ProductResponseDto());
        ResponseEntity<ProductResponseDto> response = productController.getProductByIsbn(uuid);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void update_product_returns_when_product_found(){
        UUID uuid = UUID.randomUUID();
        given(productService.updateProduct(productRequestDto, uuid)).willReturn(new ProductResponseDto());
        ResponseEntity<ProductResponseDto> response = productController.updateProduct(uuid,productRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
