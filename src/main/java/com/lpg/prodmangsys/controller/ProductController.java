package com.lpg.prodmangsys.controller;


import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.dto.product.ProductRequestDto;
import com.lpg.prodmangsys.dto.product.ProductResponseDto;
import com.lpg.prodmangsys.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@Validated
@RequestMapping(ProductController.ENDPOINT)
@Api(tags = "products")
public class ProductController {

    public static final String ENDPOINT = "/products";

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService =productService;
    }

        @PostMapping("/product")
    @ApiOperation(value = "Create a new record for a product")
    public ResponseEntity<ProductResponseDto> createProduct(
            @ApiParam(value = "product request")
            @Valid
            @RequestBody ProductRequestDto productRequestDto
    ) {
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.status(CREATED).body(productResponseDto);
    }


    @GetMapping("/product/{id}")
    @ApiOperation(value = "Get a product using its ISBN")
    public ResponseEntity<ProductResponseDto> getProductByIsbn(
            @ApiParam(value = "ID", required = true)
            @PathVariable UUID id) {
         return  ResponseEntity.ok(productService.findById(id));
    }



    @PutMapping("/product/{id}")
    @ApiOperation(value = "Update a product")
    public ResponseEntity<ProductResponseDto> updateProduct(@ApiParam(value = "ID Value", required = true) @PathVariable UUID id, @ApiParam(value = "product request") @RequestBody ProductRequestDto productRequestDto) {
        return  ResponseEntity.of(Optional.ofNullable(productService.updateProduct(productRequestDto,id)));
    }

    @DeleteMapping( "/product/{id}")
    @ApiOperation(value = "Delete a product")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {

        return productService.deleteProduct(id);
    }

    @GetMapping("/products")
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducs() {
        return  ResponseEntity.of(Optional.ofNullable(productService.findAll()));
    }

}
