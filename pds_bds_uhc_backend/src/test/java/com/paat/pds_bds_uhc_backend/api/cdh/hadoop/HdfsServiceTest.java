package com.paat.pds_bds_uhc_backend.api.cdh.hadoop;

import com.paat.pds_bds_uhc_backend.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HdfsServiceTest extends BaseTest {

    @Autowired
    private HdfsService hdfsService;

    @Test
    public void checkExists() {
        boolean exists = hdfsService.checkExists("/user/hive/warehouse/paat_ods_ubc_safe.db/ods_kafka_user_behavior_collection");
        System.out.println(exists);
    }
    
    @Test
    public void listFilesName() {
        String filePath = "/user/hive/warehouse/paat_ods_ubc_safe.db/ods_kafka_user_behavior_collection/op_day=20210331/delta_0002401_0002500";
        List<String> list = hdfsService.listFilesName(filePath);
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }
}