package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUserPage(
            @Param("userName")
            String userName,
            @Param("userSex")
            String userSex,
            @Param("startRow")
            int startRow);   // 分页： limit （当前页码-1）*每页条数, 每页条数

    int createUser(User user);

    int deleteUserById(String userId);

    int getRowCount(
            @Param("userName")
            String userName,
            @Param("userSex")
            String userSex
    );
}
