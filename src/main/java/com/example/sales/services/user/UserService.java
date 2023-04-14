package com.example.sales.services.user;

import com.example.sales.models.product.Product;
import com.example.sales.models.user.User;
import com.example.sales.models.user.UserRepository;
import com.example.sales.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public CustomReponse<Object> getAll(){
        return new CustomReponse<>(this.repository.findAll(), false, 200, "ok");
    }
    @Transactional(readOnly = true)
    public CustomReponse<Object> getOne(Long id){
        if (this.repository.existsById(id))
            return new CustomReponse<>(this.repository.findById(id).get(), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "El usuario no existe");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> insert(User user){
        if (this.repository.existsByEmail(user.getEmail()))
            return new CustomReponse<>(null, true, 400, "Usuario registrado correctamente");
        return new CustomReponse<>(this.repository.saveAndFlush(user), false, 200, "ok");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> update(User user){
        if (this.repository.existsByEmail(user.getEmail()))
            return new CustomReponse<>(this.repository.saveAndFlush(user), false, 200, "ok");
        return new CustomReponse<>(null, true, 400, "usuario no existe");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomReponse<Object> delete(User user){
        if (this.repository.existsByEmail(user.getEmail())){
            repository.delete(user);
            return new CustomReponse<>(true, false, 200, "Usuario eliminado correctamente");
        }
        return new CustomReponse<>(null, true, 400, "El usuario no existe");
    }

}
