package com.czxy.service.impl;

import com.czxy.dao.StudentTeacherDao;
import com.czxy.dao.UTeacherDao;
import com.czxy.dao.UserDao;
import com.czxy.domain.StudentTeacher;
import com.czxy.domain.UTeacher;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private UTeacherDao uTeacherDao;
    @Resource
    private StudentTeacherDao studentTeacherDao;
    @Override
    public User login(User user) {
        List<User> userList = userDao.selectAll();
        for (User thisUser : userList) {
            if (thisUser.getUsername().equals(user.getUsername()) && thisUser.getPassword().equals(user.getPassword())){
                return thisUser;
            }
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        User userMapperByName = userDao.findByName(user.getUsername());
        if (userMapperByName!=null){
            return false;
        }
        int insert = userDao.insert(user);
        return insert==1;
    }

    @Override
    public List<User> findStuList() {
        return userDao.findStuList();
    }

    @Override
    public List<User> findTeaList() {
        List<User> teaList = userDao.findTeaList();
        return teaList;
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(User user) {
        return userDao.updateByPrimaryKey(user)==1;
    }

    @Override
    public List<UTeacher> findMyTea(Integer uid) {
        List<UTeacher> myTea = uTeacherDao.findMyTea(uid);
        for (UTeacher thisList : myTea) {
            thisList.setUser(userDao.selectByPrimaryKey(thisList.getTid()));
        }
        System.out.println(myTea);
        return myTea;
    }

    @Override
    public List<StudentTeacher> findMyStu(Integer uid) {
        List<StudentTeacher> myStu = studentTeacherDao.findMyStu(uid);
        for (StudentTeacher thisStu : myStu) {
            thisStu.setUser(userDao.selectByPrimaryKey(thisStu.getSid()));
        }
        return myStu;
    }


}
