package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Product;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import com.example.APIBigboss.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductAPI {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productRepository.getAllProduct());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {

        if (productRepository.existsByName(product.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Product Name is already!"));
        }
        Product productSave = productRepository.save(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).body(productSave);
    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateCategory(@PathVariable int id,
//                                            @Valid @RequestBody Category category){
//        Optional<Category> optionalCategory= categoryRepository.findCategoryById(id);
//
//        if(!optionalCategory.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        category.setId(optionalCategory.get().getId());
//        categoryRepository.save(category);
//        return ResponseEntity.ok(optionalCategory.get());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
//        Optional<Category> optionalCategory= productRepository.findCategoryById(id);
//
//        if(!optionalCategory.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        categoryRepository.delete(optionalCategory.get());
//        return ResponseEntity.noContent().build();
//    }
}
