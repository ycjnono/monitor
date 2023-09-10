package com.changjiang.monitor.minio;

import cn.hutool.core.io.FileUtil;
import com.changjiang.monitor.log.Log;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Date;

/**
 * minio upload or download
 *
 * @Author changjiang
 * @Date 2023/9/4 since beijing
 */
@Slf4j
@Component
public class MinioUtil {

    @Resource
    private MinioConfig config;

    @Value("${minio.bucket}")
    private String defaultBucket;

    /**
     * upload
     *
     * @param fileName     原始文件名称
     * @param resourcePath 原始文件路径
     * @return 上传后文件路径
     */
    public String putObject(String fileName, String resourcePath) {
        String uploadPath = config.getUrl() + "/" + fileName;
        Date begin = new Date();
        Log.topic("MinioPutObject").log("fileName", fileName).log("filePath", resourcePath)
                .log("status", "begin").log("uploadPath", uploadPath).info(log);
        if (!FileUtil.exist(resourcePath)) {
            throw new IllegalArgumentException(resourcePath + ":file is empty");
        }
        BufferedInputStream inputStream = FileUtil.getInputStream(resourcePath);
        PutObjectArgs args = PutObjectArgs.builder().contentType(getContentType(resourcePath))
                .object(fileName).bucket(defaultBucket).stream(inputStream, -1, 10485760)
                .build();
        try {
            ObjectWriteResponse response = config.getClient().putObject(args);
            Long usedTime = new Date().getTime() - begin.getTime();
            Log.topic("MinioPutObject").log("fileName", fileName).log("filePath", resourcePath)
                    .log("status", "success").log("usedTime", usedTime)
                    .log("response", response).log("uploadPath", uploadPath).info(log);
        } catch (Exception e) {
            throw new RuntimeException("MinioPutObjectFailed,fileName=" + fileName + ",filePath=" + resourcePath, e);
        }
        return uploadPath;
    }

    /**
     * 文件上传
     *
     * @param fileName    文件名称
     * @param contentType 文件content-type
     * @param inputStream 文件流
     * @return 文件上传后路径
     */
    public String putObject(String fileName,String uploadPath, String contentType, InputStream inputStream) {
        if (StringUtils.isBlank(uploadPath)){
            uploadPath = config.getUrl() + "/" + fileName;
        }
        Date begin = new Date();
        Log.topic("MinioPutObject").log("fileName", fileName).log("contentType", contentType)
                .log("status", "begin").log("uploadPath", uploadPath).info(log);
        PutObjectArgs args = PutObjectArgs.builder().contentType(contentType)
                .object(fileName).bucket(defaultBucket).stream(inputStream, -1, 10485760)
                .build();
        try {
            ObjectWriteResponse response = config.getClient().putObject(args);
            Long usedTime = new Date().getTime() - begin.getTime();
            Log.topic("MinioPutObject").log("fileName", fileName).log("contentType", contentType)
                    .log("status", "success").log("usedTime", usedTime)
                    .log("response", response).log("uploadPath", uploadPath).info(log);
        } catch (Exception e) {
            throw new RuntimeException("MinioPutObjectFailed,fileName=" + fileName + ",contentType=" + contentType, e);
        }
        return uploadPath;
    }

    /**
     * 获取文件content-type
     *
     * @param filePath 文件路径
     * @return content-type
     */
    private String getContentType(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("file is null");
        }
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(filePath);
    }
}
