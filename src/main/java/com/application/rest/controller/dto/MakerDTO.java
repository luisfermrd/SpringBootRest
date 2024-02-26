package com.application.rest.controller.dto;

import com.application.rest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerDTO {
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
