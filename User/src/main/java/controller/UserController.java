package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import service.UserService;

import java.util.List;

@CrossOrigin // 在服务器端支持跨域访问
@RestController  // 如果本类全部都是ajax请求，则用此注解可以不写@ResponseBody
@RequestMapping("/user")
public class UserController {
    // 切记有业务逻辑层的对象
    @Autowired
    UserService userService;

    public static final int PAGE_SIZE = 5;

    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(@RequestParam("userName") String userName, @RequestParam("userSex") String userSex, @RequestParam("page") Integer page) {
        int startRow = 0;
        // 根据页码计算起始行
        if (page != null) {
            startRow = (page - 1) * PAGE_SIZE;
        }
        return userService.selectUserPage(userName, userSex, startRow);
    }

    @RequestMapping("/getRowCount")
    public int getRowCount(@RequestParam("userName")String userName, @RequestParam("userSex")String userSex) {
        return userService.getRowCount(userName, userSex);
    }

    @RequestMapping("/deleteUserById")
    public int deleteUserById(@RequestParam("userId")String userId){
        return userService.deleteUserById(userId);
    }

    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis() + "";
        user.setUserId(userId);
        return userService.createUser(user);
    }
}
