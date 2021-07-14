package com.czxy.service;

import com.czxy.domain.StudentTeacher;
import com.czxy.domain.UTeacher;
import com.czxy.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User login(User user);
    public boolean register(User user);
    public List<User> findStuList();
    public List<User> findTeaList();
    public User findById(Integer id);
    public boolean delete(Integer id);
    public boolean update(User user);
    public List<UTeacher> findMyTea(Integer uid);
    public List<StudentTeacher> findMyStu(Integer uid);
}
