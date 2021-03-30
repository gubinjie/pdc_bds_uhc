package com.paat.pds_bds_uhc_backend.api.security.user.service;

import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import com.paat.pds_bds_uhc_backend.api.security.user.model.form.UserForm;

import java.util.List;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月26日
 */
public interface UserService {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> listQuery();

    /**
     * 保存一个用户
     *
     * @param form
     * @return
     */
    int save(UserForm form);
}
