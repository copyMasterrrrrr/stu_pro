package com.czxy.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "user")
@Data
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String nickname;
    private Integer type;
    private String number;

}
