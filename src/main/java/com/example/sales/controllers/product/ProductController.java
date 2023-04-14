package com.example.sales.controllers.product;

import com.example.sales.models.product.Product;
import com.example.sales.services.product.ProductService;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-sales/product")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<CustomReponse<Object>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomReponse<Object>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomReponse<Object>> insert(@RequestBody Product product){
        return new ResponseEntity<>(this.service.insert(product), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomReponse<Object>> update(@RequestBody Product product){
        return new ResponseEntity<>(this.service.update(product), HttpStatus.CREATED);
    }
    @PatchMapping("/")
    public ResponseEntity<CustomReponse<Integer>> enableOrDisable(@RequestBody Product product){
        return new ResponseEntity<>(this.service.changeStatus(product), HttpStatus.OK);
    }
}
