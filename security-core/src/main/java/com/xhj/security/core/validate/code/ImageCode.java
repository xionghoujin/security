package com.xhj.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by 熊厚谨 on 2018/6/7 17:09
 *图片验证码
 * @author 熊厚谨
 */
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;


    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImageCode setImage(BufferedImage image) {
        this.image = image;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ImageCode setCode(String code) {
        this.code = code;
        return this;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public ImageCode setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
