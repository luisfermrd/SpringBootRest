package com.application.rest.controller;

import com.application.rest.controller.dto.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO makerDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOS = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO product) throws URISyntaxException {
        if (product.getName().isBlank() || product.getPrice() == null || product.getMaker() == null)
            return ResponseEntity.badRequest().build();
        productService.save(Product.builder().name(product.getName()).price(product.getPrice()).maker(product.getMaker()).build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO product) {

        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product1 = productOptional.get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setMaker(product.getMaker());
            productService.save(product1);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id == null) {
            productService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
