package com.paat.pds_bds_uhc_backend.api.security.user.controller;

import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月30日
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/security/user/list")
    public List<User> list(){
        return service.listQuery();
    }
}
