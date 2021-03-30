package com.paat.pds_bds_uhc_backend.api.security.user.service;

import com.paat.pds_bds_uhc_backend.BaseTest;
import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.model.form.UserForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void listQuery(){
        List<User> list = userService.listQuery();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void save() {
        UserForm userForm = new UserForm();
        userForm.setName("213");
        userForm.setAge(21);
        userForm.setSex("F");
        userForm.setAddress("上海市");
        int save = userService.save(userForm);
        System.out.println(save);
    }
}