package com.czxy.dao;

import com.czxy.domain.UTeacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UTeacherDao extends Mapper<UTeacher> {
    @Select("select * from u_teacher where uid=#{uid}")
    public List<UTeacher> findByUid(@Param("uid") Integer uid);

    @Select("SELECT DISTINCT u.uid,u.tid FROM u_teacher u ,teacher_student t WHERE u.uid=#{uid} AND u.tid=t.tid;")
    public List<UTeacher> findMyTea(@Param("uid") Integer uid);
}
