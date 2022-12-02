package com.micro.UserService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @Column(name = "id")
    private String userId;
    private String userName;
    private String email;
    private String mobileNo;
    private String password;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
