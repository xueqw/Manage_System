import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.UserService;

import java.util.List;

@ExtendWith(SpringExtension.class)  // 启动Spring容器
@ContextConfiguration(locations =  {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage(null,null,0);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void Delete(){
        int num = userService.deleteUserById("123412");
        System.out.println(num);
    }

    @Test
    public void testGetRowCount(){
        int num = userService.getRowCount(null,"男");
        System.out.println(num);
    }

    @Test
    public void testCreateUser(){
        User user = new User("1245151","天界神卡","13512025","修仙xue","男","10000000","仙界帝主");
        userService.createUser(user);
    }

}
