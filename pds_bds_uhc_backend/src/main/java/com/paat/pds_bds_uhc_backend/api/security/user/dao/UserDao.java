package com.paat.pds_bds_uhc_backend.api.security.user.dao;

import com.paat.pds_bds_uhc_backend.api.security.user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月26日
 */
@Mapper
public interface UserDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> listQuery();
    /**
     * 保存一个用户
     *
     * @param entity
     * @return
     */
    int insert(User entity);
}
