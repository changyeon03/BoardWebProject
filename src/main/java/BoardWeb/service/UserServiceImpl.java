package BoardWeb.service;

import BoardWeb.dto.UsersDTO;
import BoardWeb.repository.UsersMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public void insertUser(UsersDTO usersDTO) throws Exception {
        String HashPW = BCrypt.hashpw(usersDTO.getPassword(), BCrypt.gensalt(10));
        usersMapper.insertUser(usersDTO.getAccount(), HashPW, usersDTO.getNick_name());
    }

    @Override
    public boolean isUser(UsersDTO usersDTO) throws Exception {
        return (BCrypt.checkpw(usersDTO.getPassword()
                , usersMapper.getPassword(usersDTO.getAccount())));
    }
}
