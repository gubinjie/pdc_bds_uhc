package com.paat.pds_bds_uhc_backend.api.security.user.service.impl;

import com.paat.pds_bds_uhc_backend.api.security.user.dao.UserDao;
import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.model.form.UserForm;
import com.paat.pds_bds_uhc_backend.api.security.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月26日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listQuery() {
        return userDao.listQuery();
    }

    @Override
    public int save(UserForm form) {
        User entity = new User();
        BeanUtils.copyProperties(form,entity);
        entity.setId("213123");

        return userDao.insert(entity);
    }
}
