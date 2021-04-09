package com.paat.pds_bds_uhc_backend.api.security.user.controller;

import com.github.pagehelper.PageInfo;
import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.model.query.UserQuery;
import com.paat.pds_bds_uhc_backend.api.security.user.service.UserService;
import com.paat.pds_bds_uhc_backend.common.result.ResponseResult;
import com.paat.pds_bds_uhc_backend.exception.SessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @PostMapping("/api/security/user/query")
    public PageInfo<List<User>> query(@RequestBody UserQuery query) {
        return service.listQuery(query);
    }

    @GetMapping("/api/security/user/list")
    public ResponseResult<List<User>> list() {
        return ResponseResult.success(service.list());
    }

    @GetMapping("/open-api/security/user/query")
    public List<User> listOpen() {
        return service.list();
    }

    @GetMapping("/api/login")
    public boolean login(HttpServletRequest request, String userName, String password) throws SessionExpiredException {
        HttpSession session = request.getSession();
        session.setAttribute("USER_NAME", userName);

        throw new SessionExpiredException(401, "session过期");
    }
}
