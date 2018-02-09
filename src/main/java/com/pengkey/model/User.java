package com.pengkey.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")//code11
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "dob", length = 20)
    private Date dob;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "User")
    private Set<Role> Roles = new HashSet<Role>(0);
    public User() {
    }
    public User(String name, String email, String password, Date dob, Set<Role> Roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.Roles = Roles;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<Role> getRoles() {
        return this.Roles;
    }
    public void setRoles(Set<Role> roles) {
        this.Roles = roles;
    }
}