package com.example.sales.controllers.user;

import com.example.sales.models.product.Product;
import com.example.sales.models.user.User;
import com.example.sales.services.user.UserService;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-sales/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<CustomReponse<Object>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomReponse<Object>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomReponse<Object>> insert(@RequestBody User user){
        return new ResponseEntity<>(this.service.insert(user), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomReponse<Object>> update(@RequestBody User user){
        return new ResponseEntity<>(this.service.update(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomReponse<Object>> delete(@RequestBody User user){
        return new ResponseEntity<>(this.service.delete(user), HttpStatus.OK);
    }
}
