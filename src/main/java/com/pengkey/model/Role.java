package com.pengkey.model;

import javax.persistence.*;

@Table(name = "role")
public class Role implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId", unique = true, nullable = false)
    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private User User;

    @Column(name = "name", length = 20)
    private String name;
    public Role() {
    }
    public Role(User User) {
        this.User = User;
    }

    public Role(User User, String name) {
        this.User = User;
        this.name = name;
    }
    public Integer getRoleId() {

        return this.roleId;

    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return this.User;
    }
    public void setUser(User user) {
        this.User = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
