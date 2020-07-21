package com.milo.rest.service;

import com.milo.rest.api.v1.mapper.CategoryMapper;
import com.milo.rest.api.v1.model.CategoryDTO;
import com.milo.rest.domain.Category;
import com.milo.rest.respository.CategoryRepository;
import com.milo.rest.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    public static final String CATEGORY = "Category";
    public static final long ID = 1l;
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
    }

    @Test
    void getAllCategories() {
        //dado
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        //cuando
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        //entonces
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    void getCategoryByName() {
        //dado
        Category category = new Category();
        category.setId(ID);
        category.setName(CATEGORY);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //cuando
        CategoryDTO categoryDTO = categoryService.getCategoryByName(CATEGORY);

        //entonces
        assertEquals(ID, categoryDTO.getId());
        assertEquals(CATEGORY, categoryDTO.getName());

    }
}