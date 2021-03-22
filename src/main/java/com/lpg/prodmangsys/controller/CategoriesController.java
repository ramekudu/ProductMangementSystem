package com.lpg.prodmangsys.controller;


import com.lpg.prodmangsys.dto.categories.CategoriesRequestDto;
import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.service.CategoriesService;
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
@RequestMapping(CategoriesController.ENDPOINT)
@Api(tags = "Categoriess")
public class CategoriesController {

    public static final String ENDPOINT = "/categories";

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService =categoriesService;
    }

    @PostMapping("/category")
    @ApiOperation(value = "Create a new record for a categories")
    public ResponseEntity<CategoriesResponseDto> createCategory(
            @ApiParam(value = "Catgory request")
            @Valid
            @RequestBody CategoriesRequestDto categoriesRequestDto
    ) {
        CategoriesResponseDto categoriesResponseDto = categoriesService.createCategories(categoriesRequestDto);
        return ResponseEntity.status(CREATED).body(categoriesResponseDto);
    }


    @GetMapping("/category/{id}")
    @ApiOperation(value = "Get a Catgory using its id")
    public ResponseEntity<CategoriesResponseDto> getCategoryById(
            @ApiParam(value = "id", required = true)
            @PathVariable UUID id) {
        return  ResponseEntity.of(Optional.ofNullable(categoriesService.findById(id)));
    }

    @GetMapping("/categories")
    @ApiOperation(value = "Get a Catgory using its id")
    public ResponseEntity<List<CategoriesResponseDto>> getAllCategories() {
        return  ResponseEntity.of(Optional.ofNullable(categoriesService.findAll()));
    }



    @PutMapping("/category/{id}")
    @ApiOperation(value = "Update a category")
    public ResponseEntity<CategoriesResponseDto> updateCategory(@ApiParam(value = "id", required = true) @PathVariable UUID id, @ApiParam(value = "category request") @RequestBody CategoriesRequestDto categoriesRequestDto) {
        return  ResponseEntity.of(Optional.ofNullable(categoriesService.updateCategories(categoriesRequestDto,id)));
    }

    @DeleteMapping( "/category/{id}")
    @ApiOperation(value = "Delete a Category")
    public ResponseEntity<Void> deleteCategories(@PathVariable UUID id) {
        return categoriesService.deleteCategories(id);
    }



}
