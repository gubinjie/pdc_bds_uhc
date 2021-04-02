package com.paat.pds_bds_uhc_backend.api.cdh.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月31日
 */
@Component
public class HdfsConfig {

    private String hdfsUri = "hdfs://lo-o-cdh-01:8020";

    @Bean(name = "HdfsService")
    public HdfsService getHdfsService() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", hdfsUri);
        return new HdfsService(conf, hdfsUri);
    }
}
