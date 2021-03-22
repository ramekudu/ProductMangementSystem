package com.lpg.prodmangsys.dto.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesResponseDto {

    private UUID id;
    private String categoryName;


}

