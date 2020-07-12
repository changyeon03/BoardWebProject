package BoardWeb.controller;

import BoardWeb.dto.UsersDTO;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() { return "User/login"; }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(){
        return "User/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(UsersDTO usersDTO) throws Exception {
        if(userService.isUser(usersDTO))
        {
            return "/Board/viewboardlist";
        }
        else
            return "User/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(){
        return "User/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignup(UsersDTO usersDTO) throws Exception {
        userService.insertUser(usersDTO);
        return "User/login";
    }
}
