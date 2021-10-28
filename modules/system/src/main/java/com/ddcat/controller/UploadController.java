package com.ddcat.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.ddcat.entiry.Result;
import com.ddcat.enums.ResultEnum;
import com.ddcat.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 通用上传
 *
 * @author dd-cat
 */
@RestController
@RequestMapping("b/upload")
public class UploadController {

    @Value("${upload.prefix}")
    private String prefix;
    @Value("${upload.path}")
    private String path;

    /**
     * 上传头像
     *
     * @return -
     */
    @GetMapping("avatar")
    public Result<String> avatar(MultipartFile file) throws IOException {
        // 头像
        if (file == null || file.isEmpty()) {
            throw new BusinessException(ResultEnum.B000003);
        }
        String fileName = "avatar/" + IdUtil.simpleUUID() + "." + FileUtil.getSuffix(file.getOriginalFilename());
        FileUtil.writeFromStream(file.getInputStream(), path + fileName);
        return Result.success(prefix + fileName);
    }

}
