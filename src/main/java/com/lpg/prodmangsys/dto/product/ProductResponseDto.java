package com.lpg.prodmangsys.dto.product;

import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.entity.Categories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private UUID id;

    private String name;

    private String description;

    private CategoriesResponseDto category;

    private Date createdDate;

    private Date updatedDate;

    private Date lastPurchasedDate;




}

