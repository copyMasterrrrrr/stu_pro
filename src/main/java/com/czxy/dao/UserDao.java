package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {
    @Select("SELECT * FROM user WHERE username =#{username};")
    public User findByName(@Param("username") String username);

    //所有学生
    @Select("SELECT * FROM USER WHERE TYPE=0;")
    public List<User> findStuList();

    //所有导师
    @Select("SELECT * FROM USER WHERE TYPE=1;")
    public List<User> findTeaList();

    //模糊查询导师
    @Select("select * from user where type=1 and nickname like #{name}")
    List<User> findTeaByName(@Param("name") String name);

    //模糊查询学生
    @Select("select * from user where type=0 and nickname like #{name}")
    List<User> findStuByName(@Param("name") String name);
}
