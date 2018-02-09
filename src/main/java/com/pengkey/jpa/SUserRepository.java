package com.pengkey.jpa;

import com.pengkey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email=?1 and u.password=?2")
    User login(String email, String password);
    User findByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);
}
