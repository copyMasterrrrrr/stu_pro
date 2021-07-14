package com.czxy.dao;

import com.czxy.domain.StudentTeacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface StudentTeacherDao extends Mapper<StudentTeacher> {
    @Select("SELECT * FROM teacher_student WHERE sid=#{sid};")
    public List<StudentTeacher> findByUid(@Param("sid") Integer sid);

    @Select("SELECT DISTINCT t.sid,t.tid FROM u_teacher u ,teacher_student t WHERE t.tid=#{tid} AND u.uid=t.sid;")
    public List<StudentTeacher> findMyStu(@Param("tid") Integer tid);
}
