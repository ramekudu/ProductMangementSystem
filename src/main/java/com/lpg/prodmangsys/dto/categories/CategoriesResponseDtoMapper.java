package com.lpg.prodmangsys.dto.categories;

import com.lpg.prodmangsys.entity.Categories;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoriesResponseDtoMapper {
    public abstract CategoriesResponseDto fromEntity(Categories user);

    public abstract List<CategoriesResponseDto> fromEntityList(List<Categories> listOfCategories);

}
