package com.lab3.response;

import com.lab3.mybatis.po.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListResponse {
    private List<User> userList;

    public UserListResponse(List<User> userList){
        this.userList = userList;
    }

    public List<String> getResponse(){
        List<String> resList = new ArrayList<>();
        for(User user:userList){
            resList.add(user.toString());
        }
        return resList;
    }
}
