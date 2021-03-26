package com.paat.pds_bds_uhc_backend.api.security.user.service;

import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月26日
 */
public interface UserService {

    /**
     * 保存一个用户
     *
     * @param entity
     * @return
     */
    int save(User entity);
}
