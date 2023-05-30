package com.lab3.controller;

import com.lab3.mybatis.SqlSessionLoader;
import com.lab3.mybatis.po.User;
import com.lab3.request.UserLoginRequest;
import com.lab3.request.UserRegisterRequest;
import com.lab3.response.ErrorResponse;
import com.lab3.response.UserListResponse;
import com.lab3.response.UserLoginResponse;
import com.lab3.response.UserRegisterResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("com.lab3.UserMapper.findUserByUsername", request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        }
        else {
            sqlSession.insert("com.lab3.UserMapper.addUser", new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new UserRegisterResponse("Register Successfully!");
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public @ResponseBody Object login(@RequestBody UserLoginRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("com.lab3.UserMapper.findUserByUsername", request.getUsername());
        if (user != null){
            if(request.getPassword().equals(user.getPassword())) {
                sqlSession.close();
                return new UserLoginResponse("Login Successfully");
            }
            else{
                sqlSession.close();
                return new ErrorResponse("Wrong Password");
            }
        }
        else{
            sqlSession.close();
            return new ErrorResponse("Can't find the user");
        }
    }

    @RequestMapping(value="/showList", method = RequestMethod.GET)
    public @ResponseBody Object listAllUsers() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<User> userList = sqlSession.selectList("com.lab3.UserMapper.selectAll");
        return new UserListResponse(userList).getResponse();
    }
}
