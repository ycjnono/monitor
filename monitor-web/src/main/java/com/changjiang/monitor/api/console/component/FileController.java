package com.changjiang.monitor.api.console.component;

import com.changjiang.monitor.minio.MinioUtil;
import com.changjiang.monitor.user.wrapper.UserTokenWrapper;
import com.changjiang.monitor.user.wrapper.UserWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

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
        String uploadPath = Objects.requireNonNull(UserTokenWrapper.currentUser()).getTenantId();
        return minioUtil.putObject(name, uploadPath, contentType, inputStream);
    }
}
