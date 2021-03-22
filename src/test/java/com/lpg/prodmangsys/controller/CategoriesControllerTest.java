package com.lpg.prodmangsys.controller;


import com.lpg.prodmangsys.dto.categories.CategoriesRequestDto;
import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.service.CategoriesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class CategoriesControllerTest {
    @InjectMocks
    private CategoriesController categoriesController;

    @Mock
    private CategoriesService categoriesService;

    @Mock
    private CategoriesRequestDto categoriesRequestDto;

    @Test
    void get_categories_returns_when_no_categories_found(){
        ResponseEntity<CategoriesResponseDto> response = categoriesController.getCategoryById(UUID.randomUUID());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void create_categories_returns_success(){
        given(categoriesService.createCategories(categoriesRequestDto)).willReturn(new CategoriesResponseDto());
        ResponseEntity<CategoriesResponseDto> response = categoriesController.createCategory(categoriesRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void get_categories_returns_when_categories_found(){
        UUID uuid = UUID.randomUUID();
        given(categoriesService.findById(uuid)).willReturn(new CategoriesResponseDto());
        ResponseEntity<CategoriesResponseDto> response = categoriesController.getCategoryById(uuid);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void update_categories_returns_when_categories_found(){
        UUID uuid = UUID.randomUUID();
        given(categoriesService.updateCategories(categoriesRequestDto, uuid)).willReturn(new CategoriesResponseDto());
        ResponseEntity<CategoriesResponseDto> response = categoriesController.updateCategory(uuid,categoriesRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
