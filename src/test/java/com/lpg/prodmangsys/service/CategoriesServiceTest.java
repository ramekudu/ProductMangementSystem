package com.lpg.prodmangsys.service;

import com.lpg.prodmangsys.dto.categories.CategoriesResponseDtoMapper;
import com.lpg.prodmangsys.exception.CategoriesNotFoundException;
import com.lpg.prodmangsys.repository.CategoriesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CategoriesServiceTest {

    @Mock
    private CategoriesRepository categoriesRepository;

    @InjectMocks
    private CategoriesService categoriesService;

    @Mock
    private CategoriesResponseDtoMapper categoriesResponseDtoMapper;


    @Test
    void fails_when_categoriess_are_not_found(){
        UUID uuid = UUID.randomUUID();
        given(categoriesRepository.findById(uuid)).willReturn(Optional.empty());
        assertThrows(CategoriesNotFoundException.class, () -> categoriesService.findById(uuid));
    }
}
