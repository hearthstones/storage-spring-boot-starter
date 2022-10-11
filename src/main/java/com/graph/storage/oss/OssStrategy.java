package com.graph.storage.oss;

import com.alibaba.fastjson.JSONObject;
import com.graph.storage.common.StorageStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 阿里云oss策略
 *
 * @author luchao
 * @since 2022/9/26
 */
@Slf4j
public class OssStrategy implements StorageStrategy {

    @Override
    public JSONObject upload(MultipartFile file) {
        return null;
    }

    @Override
    public List<JSONObject> multiUpload(MultipartFile[] files) {
        return null;
    }

}
