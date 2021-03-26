package com.paat.pds_bds_uhc_backend.api.security.user.model.entity;

import com.paat.pds_bds_uhc_backend.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月26日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

}
