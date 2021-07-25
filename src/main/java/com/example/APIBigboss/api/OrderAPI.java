package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Order;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import com.example.APIBigboss.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderAPI {
   @Autowired
   private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok(orderRepository.getAllOrder());
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> getCategoryByID(@PathVariable int id) {
//        Optional<Category> optionalCategory = categoryRepository.findCategoryById(id);
//        if (!optionalCategory.isPresent()) {
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        return ResponseEntity.ok(optionalCategory.get());
//    }
    @PostMapping("/add")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order) {

        Order orderSaved = orderRepository.save(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();
        return ResponseEntity.created(location).body(orderSaved);
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

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
//        Optional<Category> optionalCategory= categoryRepository.findCategoryById(id);
//
//        if(!optionalCategory.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        categoryRepository.delete(optionalCategory.get());
//        return ResponseEntity.noContent().build();
//    }
}
