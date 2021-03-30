package com.paat.pds_bds_uhc_backend.api.security.user.model.dto;

import com.paat.pds_bds_uhc_backend.common.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月30日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseDTO {
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
