/**
 * @author Littleor < me@littleor.cn >
 * @file {PACKAGE_NAME}
 * @createTime 2021/8/20 17:32
 */
package org.controller;

import org.mybatis.entity.User;
import org.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/insert", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String insertUser() {
        User user = new User();
        user.setName("小明");
        user.setPassword("44555");
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return user.toString();
    }

    @RequestMapping(value = "/findAll", produces = {"application/json; charset=UTF-8"})
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
