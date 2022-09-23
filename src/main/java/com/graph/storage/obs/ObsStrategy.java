package com.graph.storage.obs;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.graph.storage.common.StorageStrategy;
import com.obs.services.ObsClient;
import com.obs.services.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 华为云obs策略
 *
 * @author luchao
 * @since 2022/9/23
 */
@Slf4j
public class ObsStrategy implements StorageStrategy {

    @Resource
    private ObsProperties obsProperties;
    @Resource
    private ObsClient obsClient;

    /**
     * 文件上传
     *
     * @param file 文件
     */
    @Override
    public JSONObject upload(MultipartFile file) {
        // 文件ID、文件名
        String id = IdUtil.simpleUUID();
        String originName = file.getOriginalFilename();
        String extName = FileUtil.extName(originName);
        String fileName = id + "." + extName;
        // 上传
        String url = "";
        try {
            PutObjectResult putObjectResult = obsClient.putObject(obsProperties.getBucketName(), fileName, file.getInputStream());
            url = putObjectResult.getObjectUrl().replaceAll(":443", "");
        } catch (IOException e) {
            log.error("文件上传失败！文件名：{}，异常信息：{}", originName, e);
        }
        // result
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("url", url);
        result.put("date", LocalDateTime.now());
        return result;
    }

    @Override
    public List<JSONObject> multiUpload(MultipartFile[] files) {
        return Arrays.stream(files).map(this::upload).collect(Collectors.toList());
    }

}
