package com.lpg.prodmangsys.repository;

import com.lpg.prodmangsys.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {

    public Optional<Categories> findByCategoryName(String categoryName);
}
