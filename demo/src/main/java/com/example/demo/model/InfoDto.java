package com.example.demo.model;

import lombok.Data;

/**
 * @author liutianlong
 */
@Data
public class InfoDto {

    /**
     * 异步(唯一标志)
     */
    private String asyncKey;

    /**
     * url
     */
    private String url;
}
