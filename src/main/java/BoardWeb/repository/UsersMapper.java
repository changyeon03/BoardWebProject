package BoardWeb.repository;

import BoardWeb.dto.UsersDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    @Select(value = "SELECT * FROM users")
    List<UsersDTO> getUserList();

    @Select(value = "SELECT password FROM users WHERE account = #{account}")
    String getPassword(@Param("account") String account);

    @Insert(value = "INSERT INTO users(account, password, nick_name) VALUES(#{account}, #{password}, #{nick_name}) ")
    void insertUser(@Param("account") String account, @Param("password") String password, @Param("nick_name") String nick_name);


}

