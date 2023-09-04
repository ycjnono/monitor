package com.changjiang.monitor.api.console.component;

import com.changjiang.monitor.minio.MinioUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传
 *
 * @Author changjiang
 * @Date 2023/9/4 since beijing
 */
@RestController
@RequestMapping("/component/file")
public class FileController {

    @Resource
    private MinioUtil minioUtil;

    @PostMapping("/putObject")
    public Object putObject(@RequestParam(name = "file") MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String contentType = file.getContentType();
        InputStream inputStream = file.getInputStream();
        return minioUtil.putObject(name, contentType, inputStream);
    }
}
