package com.lpg.prodmangsys.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotNull(message ="name  is required")
    @Size(max = 100)
    private String name;

    @NotNull(message ="description  is required")
    @Size(min = 1 , max = 100)
    private String description;

    @NotNull(message ="Category name is required")
    private String categoryName;



}
