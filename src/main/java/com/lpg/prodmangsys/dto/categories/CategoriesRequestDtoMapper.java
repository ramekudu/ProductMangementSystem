package com.lpg.prodmangsys.dto.categories;

import com.lpg.prodmangsys.entity.Categories;
import com.lpg.prodmangsys.repository.CategoriesRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class CategoriesRequestDtoMapper {

    private CategoriesRepository categoriesRepository;
    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @Mapping(target = "id", ignore = true)
    public abstract Categories toEntity(CategoriesRequestDto userRequestDto);

    public Categories fromCategoryName(String categoryName){
        return categoryName != null ? categoriesRepository.findByCategoryName(categoryName).orElse(null):null;    }
}
