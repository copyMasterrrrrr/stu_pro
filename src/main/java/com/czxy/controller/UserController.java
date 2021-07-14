package com.czxy.controller;

import com.czxy.dao.StudentTeacherDao;
import com.czxy.dao.UTeacherDao;
import com.czxy.dao.UserDao;
import com.czxy.domain.StudentTeacher;
import com.czxy.domain.UTeacher;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UTeacherDao uTeacherDao;
    @Resource
    private UserDao userDao;
    @Resource
    private StudentTeacherDao studentTeacherDao;

    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(User user, HttpSession httpSession){
        User login = userService.login(user);
        httpSession.setAttribute("user",login);
        if (login!=null && login.getType()==2){
            userService.findTeaList().forEach(System.out::println);
            httpSession.setAttribute("stuList",userService.findStuList());
            httpSession.setAttribute("teaList",userService.findTeaList());
            return "/admin/home.jsp";
        }else if (login!=null && login.getType()==0){
            httpSession.setAttribute("teaList",userService.findTeaList());
            httpSession.setAttribute("myTea",userService.findMyTea(login.getId()));
            userService.findMyTea(user.getId()).forEach(System.out::println);
            return "/student/home.jsp";
        }else if (login!=null && login.getType()==1){
            httpSession.setAttribute("myStu",userService.findMyStu(login.getId()));
            httpSession.setAttribute("stuList",userService.findStuList());
            return "/teacher/home.jsp";
        }
        else {
            httpSession.setAttribute("loginMsg","用户名或密码有误");
            return "index.jsp";
        }
    }

    @RequestMapping(value = "/register.action",method = RequestMethod.POST)
    public String register(User user, HttpSession httpSession){
        System.out.println(user);
        boolean b = userService.register(user);
        if (b){
            return "index.jsp";
        }
        httpSession.setAttribute("registerMsg","账号已存在");
        return "register.jsp";
    }

    @RequestMapping("/findAllStu.action")
    public String findStuList(HttpSession httpSession){
        List<User> stuList = userService.findStuList();
        httpSession.setAttribute("stuList",stuList);
        return "/admin/stuList.jsp";
    }

    @RequestMapping("/findAllTea.action")
    public String findTeaList(HttpSession httpSession){
        List<User> teaList = userService.findTeaList();
        httpSession.setAttribute("teaList",teaList);
        return "/admin/stuList.jsp";
    }

    //添加学生
    @RequestMapping(value = "/add.action",method = RequestMethod.POST)
    public String add(User user, HttpSession httpSession){
        System.out.println(user);
        if (user.getUsername().equals("") || user.getPassword().equals("") || user.getSex().equals("") || user.getPhone().equals("") || user.getNickname().equals("")){
            httpSession.setAttribute("addMsg","表单不能未空");
            return "/admin/addStu.jsp";
        }
        boolean b = userService.register(user);
        if (b){
            if (user.getType()==0){
                httpSession.setAttribute("stuList",userService.findStuList());
                return "/admin/stuList.jsp";
            }else {
                httpSession.setAttribute("teaList",userService.findTeaList());
                return "/admin/teaList.jsp";
            }
        }
        httpSession.setAttribute("addMsg","账号已存在");
        return "/admin/addStu.jsp";
    }

    @RequestMapping("/findById.action")
    public String findById(String uid,HttpSession httpSession){
        User user = userService.findById(Integer.parseInt(uid));
        if (user.getType()==0){
            httpSession.setAttribute("stu",user);
            return "/admin/updateStu.jsp";
        }
        httpSession.setAttribute("tea",user);
        return "/admin/updateTea.jsp";
    }

    @RequestMapping("/delete.action")
    public String delete(String uid,HttpSession httpSession){
        User user = userService.findById(Integer.parseInt(uid));
        userService.delete(Integer.parseInt(uid));
        if (user.getType()==0){
            httpSession.setAttribute("stuList",userService.findStuList());
            return "/admin/stuList.jsp";
        }
        httpSession.setAttribute("teaList",userService.findTeaList());
        return "/admin/teaList.jsp";
    }

    @RequestMapping(value = "/update.action",method = RequestMethod.POST)
    public String update(User user,HttpSession httpSession){
        System.out.println(user);
        if (user.getUsername().equals("") || user.getPassword().equals("") || user.getSex().equals("") || user.getPhone().equals("") || user.getNickname().equals("")){
            httpSession.setAttribute("updateMsg","表单不能未空");
            return "/admin/addStu.jsp";
        }
        userService.update(user);
        if (user.getType()==0){
            httpSession.setAttribute("stuList",userService.findStuList());
            return "/admin/stuList.jsp";
        }
        httpSession.setAttribute("teaList",userService.findTeaList());
        return "/admin/teaList.jsp";
    }

    @RequestMapping(value = "/updateMyInformation.action",method = RequestMethod.POST)
    public String updateMyInformation(User user,HttpSession httpSession){
        System.out.println(user);
        if (user.getUsername().equals("") || user.getPassword().equals("") || user.getSex().equals("") || user.getPhone().equals("") || user.getNickname().equals("")){
            httpSession.setAttribute("updateMsg","表单不能未空");
            return "/student/information.jsp";
        }
        userService.update(user);
        if (user.getType()==0){
            httpSession.setAttribute("user",user);
            httpSession.setAttribute("updateIn","保存成功");
            return "/student/information.jsp";
        }
        httpSession.setAttribute("user",user);
        httpSession.setAttribute("updateIn","保存成功");
        return "/teacher/information.jsp";
    }

    @RequestMapping(value = "/choiceTea.action",method = RequestMethod.POST)
    public String choiceTea(UTeacher uTeacher,HttpSession httpSession){
        System.out.println(uTeacher);
        for (Integer thisTid : uTeacher.getTids()) {
            UTeacher uTeacherNew = new UTeacher();
            uTeacherNew.setUid(uTeacher.getUid());
            uTeacherNew.setTid(thisTid);
            uTeacherDao.insert(uTeacherNew);
        }
        httpSession.setAttribute("choice","选择导师成功");
        return "/student/choiceTea.jsp";
    }

    @RequestMapping(value = "/choiceStu.action",method = RequestMethod.POST)
    public String choiceStu(StudentTeacher studentTeacher, HttpSession httpSession){
        System.out.println(studentTeacher);
        for (Integer thisSid : studentTeacher.getSids()) {
            StudentTeacher studentTeacherNew = new StudentTeacher();
            studentTeacherNew.setSid(thisSid);
            studentTeacherNew.setTid(studentTeacher.getTid());
            studentTeacherDao.insert(studentTeacherNew);
        }
        httpSession.setAttribute("choice","选择学生成功");
        return "/teacher/choiceStu.jsp";
    }

    @RequestMapping(value = "/findByTeaName.action",method = RequestMethod.POST)
    public String findByTeaName(String name,HttpSession httpSession){
        List<User> teaList = userDao.findTeaByName("%" + name + "%");
        httpSession.setAttribute("teaList",teaList);
        return "/student/teaList.jsp";
    }

    @RequestMapping("/findMyTea.action")
    public String findMyTea(String uid,HttpSession httpSession){
        List<UTeacher> myTea = userService.findMyTea(Integer.parseInt(uid));
        httpSession.setAttribute("myTea",myTea);
        return "/student/myTea.jsp";
    }

    @RequestMapping(value = "/findByStuName.action",method = RequestMethod.POST)
    public String findByStuName(String name,HttpSession httpSession){
        List<User> teaList = userDao.findStuByName("%" + name + "%");
        httpSession.setAttribute("stuList",teaList);
        return "/teacher/stuList.jsp";
    }
}
