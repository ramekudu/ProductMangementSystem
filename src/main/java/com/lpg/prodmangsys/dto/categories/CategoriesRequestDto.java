package com.lpg.prodmangsys.dto.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequestDto {

    @NotNull(message ="Catgory Name is required")
    @Size(min = 1 , max = 100)
    private String categoryName;


}
