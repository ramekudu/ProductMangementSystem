package com.lpg.prodmangsys.dto.product;

import com.lpg.prodmangsys.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class ProductResponseDtoMapper {


    public abstract ProductResponseDto fromEntity(Product book);

    public abstract List<ProductResponseDto> fromEntityList(List<Product> listOfProduct);


}
