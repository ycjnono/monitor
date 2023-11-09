package com.changjiang.monitor.minio;

import com.changjiang.monitor.log.Log;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
     * This method is used to put an object into a storage system.
     *
     * @param fileName    The name of the object to be stored.
     * @param uploadPath  The path where the object should be stored.
     * @param contentType The content type of the object.
     * @param inputStream The input stream containing the object data.
     * @return A string indicating the result of the operation.
     */
    public String putObject(String fileName, String uploadPath, String contentType, InputStream inputStream) {
        if (StringUtils.isBlank(uploadPath)) {
            uploadPath = fileName;
        } else {
            uploadPath = uploadPath + "/" + fileName;
        }
        Date begin = new Date();
        Log.topic("MinioPutObject").log("fileName", fileName).log("contentType", contentType)
                .log("status", "begin").log("uploadPath", uploadPath).info(log);
        PutObjectArgs args = PutObjectArgs.builder().contentType(contentType)
                .object(uploadPath).bucket(defaultBucket).stream(inputStream, -1, 10485760)
                .build();
        try {
            ObjectWriteResponse response = config.getClient().putObject(args);
            uploadPath = config.getUrl() + "/" + uploadPath;
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
