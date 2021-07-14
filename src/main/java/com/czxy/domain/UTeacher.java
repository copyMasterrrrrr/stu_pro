package com.czxy.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "u_teacher")
@Data
public class UTeacher {
    @Id
    private Integer id;
    private Integer uid;
    private Integer tid;

    @Transient
    private List<Integer> tids;

    private User user;
}
