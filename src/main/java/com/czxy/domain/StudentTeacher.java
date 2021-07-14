package com.czxy.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "teacher_student")
@Data
public class StudentTeacher {
    @Id
    private Integer id;
    private Integer sid;
    private Integer tid;

    @Transient
    private List<Integer> sids;
    private User user;
}
