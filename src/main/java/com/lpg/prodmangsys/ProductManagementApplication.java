package com.lpg.prodmangsys;

import com.lpg.prodmangsys.dto.categories.CategoriesResponseDto;
import com.lpg.prodmangsys.dto.product.ProductRequestDto;
import com.lpg.prodmangsys.dto.categories.CategoriesRequestDto;
import com.lpg.prodmangsys.service.ProductService;
import com.lpg.prodmangsys.service.CategoriesService;
import org.jeasy.random.EasyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

@SpringBootApplication
public class ProductManagementApplication
{
    @Autowired
    ProductService productService;
    @Autowired
    CategoriesService categoriesService;


    public static void main( String[] args ){
        SpringApplication.run(ProductManagementApplication.class, args);

    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

    @PostConstruct
    public void initApplication() throws IOException {


        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Power Tools").build());
        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Furniture").build());
        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Electric").build());
        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Washroom").build());
        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Textiles").build());
        categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Misc").build());

        CategoriesResponseDto catResponseDto = categoriesService.createCategories(CategoriesRequestDto.builder().categoryName("Kitchen").build());

        productService.createProduct(ProductRequestDto.builder().name("Knife Set").description("A set of knives in all shapes and sizes.").categoryName(catResponseDto.getCategoryName()).build());
    }
}

