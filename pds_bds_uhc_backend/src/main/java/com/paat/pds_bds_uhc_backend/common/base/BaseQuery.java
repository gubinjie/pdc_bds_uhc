package com.paat.pds_bds_uhc_backend.common.base;

import com.github.pagehelper.IPage;
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
public class BaseQuery implements IPage {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String orderBy;
}
