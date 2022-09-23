package com.graph.storage.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 对象存储策略
 *
 * @author luchao
 * @since 2022/9/17
 */
public interface StorageStrategy {

    /**
     * 文件上传
     *
     * @param file 文件
     * @return {"id": "xxx", "url": "xxx", "date": "xxx"}
     */
    JSONObject upload(MultipartFile file);

    /**
     * 多文件上传
     *
     * @param files 多文件数组
     * @return [{"id": "xxx", "url": "xxx", "date": "xxx"}, {}, ...]
     */
    List<JSONObject> multiUpload(MultipartFile[] files);

}
