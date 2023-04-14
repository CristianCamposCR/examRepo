package com.example.sales.services.transaction;

import com.example.sales.models.transaction.Transaction;
import com.example.sales.models.transaction.TransactionRepository;
import com.example.sales.models.user.User;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.sql.SQLException;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Transactional(readOnly = true)
    public CustomReponse<Object> getAll(){
        return new CustomReponse<>(this.repository.findAll(), false, 200, "ok");
    }
    @Transactional(readOnly = true)
    public CustomReponse<Object> getOne(Long id){
        if (this.repository.existsById(id))
            return new CustomReponse<>(this.repository.findById(id), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "La transaccion no existe");
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public CustomReponse<Object> insert (Transaction transaction){
        if (this.repository.existsById(transaction.getId()))
            return new CustomReponse<>(null, true, 400, "La categoria ya existe");
        return new CustomReponse<>(this.repository.saveAndFlush(transaction), false, 200, "transaccion registrada correctamente");
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public CustomReponse<Object> update(Transaction transaction) {
        if (this.repository.existsById(transaction.getId()))
            return new CustomReponse<>(this.repository.saveAndFlush(transaction), false, 200, "actualizado correcatemente");
        return new CustomReponse<>(null,  true, 400, "la transaccion no existe");

    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> delete(Transaction transaction){
        if (this.repository.existsById(transaction.getId())){
            repository.delete(transaction);
            return new CustomReponse<>(true, false, 200, "transaccion eliminada correctamente");
        }
        return new CustomReponse<>(null, true, 400, "El usuario no existe");
    }



}
