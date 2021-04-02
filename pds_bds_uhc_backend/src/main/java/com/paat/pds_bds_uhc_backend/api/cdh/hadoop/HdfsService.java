package com.paat.pds_bds_uhc_backend.api.cdh.hadoop;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月31日
 */
@Slf4j
public class HdfsService {

    private Configuration conf = null;
    private String hdfsUri;

    public HdfsService(Configuration conf, String hdfsUri) {
        this.conf = conf;
        this.hdfsUri = hdfsUri;
    }

    private FileSystem getFileSystem() throws IOException {
        return FileSystem.get(conf);
    }

    private String generateIntegralPath(String relativePath) {
        String defaultPath = hdfsUri;
        if (relativePath.startsWith("/")) {
            return defaultPath + relativePath;
        }
        return defaultPath + "/" + relativePath;
    }

    public boolean checkExists(String relativePath) {
        FileSystem fileSystem = null;
        try {
            fileSystem = getFileSystem();
            String integralPath = generateIntegralPath(relativePath);

            return fileSystem.exists(new Path(integralPath));
        } catch (IOException e) {
            log.error("hdfs文件系统关闭失败", e);
            return false;
        } finally {
            close(fileSystem);
        }
    }

    public boolean mkdir(String relativePath) {
        if (!checkExists(relativePath)) {
            FileSystem fileSystem = null;
            try {
                fileSystem = getFileSystem();
                String integralPath = generateIntegralPath(relativePath);

                return fileSystem.mkdirs(new Path(integralPath));
            } catch (IOException e) {
                log.error("hdfs文件系统关闭失败", e);
                return true;
            } finally {
                close(fileSystem);
            }
        }

        return true;
    }

    public List<String> listFilesName(String relativePath) {
        List<String> list = new ArrayList<>();
        if (checkExists(relativePath)) {
            FileSystem fileSystem = null;
            try {
                fileSystem = getFileSystem();
                String integralPath = generateIntegralPath(relativePath);

                FileStatus[] filesNameArray = fileSystem.listStatus(new Path(integralPath));
                for (FileStatus fileStatus : filesNameArray) {
                    if (!fileStatus.isFile()) {
                        continue;
                    }
                    list.add(fileStatus.getPath().getName());
                }

                return list;
            } catch (IOException e) {
                log.error("hdfs文件系统关闭失败", e);
            } finally {
                close(fileSystem);
            }
        }

        return list;
    }

    public void close(FileSystem fileSystem) {
        if (null != fileSystem) {
            try {
                fileSystem.close();
            } catch (IOException e) {
                log.error("hdfs文件系统关闭失败", e);
            }
        }
    }
}
