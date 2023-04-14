package com.example.sales.controllers.transaction;

import com.example.sales.models.transaction.Transaction;
import com.example.sales.services.transaction.TransactionService;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-sales/transaction")
@CrossOrigin(origins = {"*"})
public class TransactionController {
    @Autowired
    private TransactionService service;

    @GetMapping("/")
    public ResponseEntity<CustomReponse<Object>> getALl(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomReponse<Object>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomReponse<Object>> insert(@RequestBody Transaction transaction){
        return new ResponseEntity<>(this.service.insert(transaction), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<CustomReponse<Object>> update(@RequestBody Transaction transaction){
        return new ResponseEntity<>(this.service.update(transaction), HttpStatus.OK);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomReponse<Object>> delete(@RequestBody Transaction transaction){
        return new ResponseEntity<>(this.service.delete(transaction), HttpStatus.OK);
    }
}
