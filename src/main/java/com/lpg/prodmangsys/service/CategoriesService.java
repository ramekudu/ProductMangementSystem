package com.lpg.prodmangsys.service;

import com.lpg.prodmangsys.dto.categories.CategoriesRequestDto;
import com.lpg.prodmangsys.dto.categories.CategoriesRequestDtoMapper;
import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.dto.categories.CategoriesResponseDtoMapper;
import com.lpg.prodmangsys.entity.Categories;
import com.lpg.prodmangsys.exception.CategoriesNotFoundException;
import com.lpg.prodmangsys.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    private final CategoriesRequestDtoMapper categoriesRequestDtoMapper;
    private final CategoriesResponseDtoMapper categoriesResponseDtoMapper;


    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository,
                             CategoriesRequestDtoMapper categoriesRequestDtoMapper,
                             CategoriesResponseDtoMapper categoriesResponseDtoMapper) {
        this.categoriesRepository = categoriesRepository;
        this.categoriesRequestDtoMapper = categoriesRequestDtoMapper;
        this.categoriesResponseDtoMapper = categoriesResponseDtoMapper;
    }

    public CategoriesResponseDto createCategories(CategoriesRequestDto categoriesRequestDto) {
        Categories categories =  categoriesRequestDtoMapper.toEntity(categoriesRequestDto);
        Categories createdCategories = categoriesRepository.save(categories);
        return categoriesResponseDtoMapper.fromEntity(createdCategories);

    }



    public List<CategoriesResponseDto> findAll() {
        List<Categories> listOfCategories = categoriesRepository.findAll();
        return categoriesResponseDtoMapper.fromEntityList(listOfCategories);
    }

    public CategoriesResponseDto findById(UUID id) {
        Optional<Categories> foundCategories = categoriesRepository.findById(id);
        return foundCategories.map(categoriesResponseDtoMapper::fromEntity).orElseThrow(() -> new CategoriesNotFoundException(id));
    }



    public CategoriesResponseDto updateCategories(CategoriesRequestDto categoriesRequestDto, UUID id) {
        Optional<Categories> foundCategories = categoriesRepository.findById(id);
        Categories updatedCategoriesInstance;
        if(foundCategories.isPresent()) {
            Categories categories = categoriesRequestDtoMapper.toEntity(categoriesRequestDto);
            updatedCategoriesInstance = categoriesRepository.save(categories);
        }
        else throw new CategoriesNotFoundException(id);

        return categoriesResponseDtoMapper.fromEntity(updatedCategoriesInstance);
    }

    public ResponseEntity<Void> deleteCategories(UUID isbn) {
        Optional<Categories> categories = categoriesRepository.findById(isbn);
        if(categories.isPresent()) {
            categoriesRepository.delete(categories.get());
        }
        return null;
    }


}

