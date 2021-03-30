package com.paat.pds_bds_uhc_backend.api.security.user.controller;

import com.github.pagehelper.PageInfo;
import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.model.query.UserQuery;
import com.paat.pds_bds_uhc_backend.api.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/security/user/list")
    public PageInfo<List<User>> list(@RequestBody UserQuery query){
        return service.listQuery(query);
    }
}
