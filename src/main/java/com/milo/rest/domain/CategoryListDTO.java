package com.milo.rest.domain;

import com.milo.rest.api.v1.model.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {

    List<CategoryDTO> categories;

}
