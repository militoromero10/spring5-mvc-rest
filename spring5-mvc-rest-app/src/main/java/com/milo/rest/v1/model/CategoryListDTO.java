package com.milo.rest.api.v1.model;

import com.milo.rest.api.v1.model.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {

    List<CategoryDTO> categories;

}
