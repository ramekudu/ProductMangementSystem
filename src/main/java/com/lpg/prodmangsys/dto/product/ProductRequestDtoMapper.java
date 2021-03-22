package com.lpg.prodmangsys.dto.product;

import com.lpg.prodmangsys.dto.categories.CategoriesRequestDtoMapper;
import com.lpg.prodmangsys.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CategoriesRequestDtoMapper.class})
public abstract class ProductRequestDtoMapper {

    @Mapping(source = "categoryName", target = "category")
    public abstract Product toEntity(ProductRequestDto productRequestDto);





}
