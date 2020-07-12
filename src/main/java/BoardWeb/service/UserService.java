package BoardWeb.service;

import BoardWeb.dto.UsersDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    public void insertUser(UsersDTO usersDTO) throws Exception;
    public boolean isUser(UsersDTO usersDTO) throws Exception;
}
