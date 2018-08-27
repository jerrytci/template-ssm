package ssm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.UserEntity;
import ssm.mapper.UserMapper;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ModelAndView i() {
        List<UserEntity> users = userMapper.getAllUser();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index2");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String i2() {
        return "index2";
    }

    // json data - ajax
    @RequestMapping(value = "/a", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity a() {
        List<UserEntity> users = userMapper.getAllUser();
        return ResponseEntity.ok(new Gson().toJson(users));
    }


}