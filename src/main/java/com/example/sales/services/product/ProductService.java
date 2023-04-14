package com.example.sales.services.product;

import com.example.sales.models.product.Product;
import com.example.sales.models.product.ProductRepository;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public CustomReponse<Object> getAll(){
        return new CustomReponse<>(this.repository.findAll(), false, 200, "ok");
    }
    @Transactional(readOnly = true)
    public CustomReponse<Object> getOne(Long id){
        if (this.repository.existsById(id))
            return new CustomReponse<>(this.repository.findById(id).get(), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "El producto no existe");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> insert(Product product){
        if (this.repository.existsByName(product.getName()))
            return new CustomReponse<>(null, true, 400, "Producto registrado correctamente");
        return new CustomReponse<>(this.repository.saveAndFlush(product), false, 200, "ok");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> update(Product product){
        if (this.repository.existsByName(product.getName()))
            return new CustomReponse<>(this.repository.saveAndFlush(product), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "Producto no existe");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Integer> changeStatus(Product product){
        if (this.repository.existsById(product.getId()))
            return new CustomReponse<>(this.repository.updateStatusById(product.getStatus(), product.getId() ), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "El producto no existe");
    }
}
