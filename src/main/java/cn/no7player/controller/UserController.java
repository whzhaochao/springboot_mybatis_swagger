package cn.no7player.controller;

import cn.no7player.model.User;
import cn.no7player.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {



    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "dbUser")
    public List<User> getUserInfo() {
        return userService.getUserInfo();
    }
    /*
     *  http://localhost:8080/swagger/index.html
     */

    /**
     *
     * @return
     */
    @ApiOperation(value="获取所有用户",notes="requires noting")
    @RequestMapping(method=RequestMethod.GET)
    public List<User> getUsers(){
        List<User> list=new ArrayList<User>();

        User user=new User();
        user.setName("hello");
        list.add(user);

        User user2=new User();
        user.setName("world");
        list.add(user2);
        return list;
    }

    @ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public User getUserById(@PathVariable String name){
        User user=new User();
        user.setName("hello world");
        return user;
    }
}
