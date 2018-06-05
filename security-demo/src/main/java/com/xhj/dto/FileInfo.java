package com.xhj.dto;

import lombok.Data;

/**
 * Created by 熊厚谨 on 2018/5/31 15:03
 *
 * @author 熊厚谨
 */
@Data
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;
}
