package com.pengkey.service;

import com.pengkey.jpa.SUserRepository;
import com.pengkey.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SUserService  {
    @Autowired

    private SUserRepository suserRepository;//code10



    public List<User> findAll() {

        return suserRepository.findAll();

    }



    public User create(User user) {

        return suserRepository.save(user);

    }



    public User findUserById(int id) {

        return suserRepository.findOne(id);

    }



    public User login(String email, String password) {

        return suserRepository.findByEmailAndPassword(email, password);

    }



    public User update(User user) {

        return suserRepository.save(user);

    }



    public void deleteUser(int id) {

        suserRepository.delete(id);

    }



    public User findUserByEmail(String email) {

        return suserRepository.findUserByEmail(email);

    }
}
