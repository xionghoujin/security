package com.xhj.security.core.validate.code;

import com.xhj.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by 熊厚谨 on 2018/6/11 17:17
 *
 * @author 熊厚谨
 */
@RestController
public class ValidateCodeController{

    @Autowired
    private SecurityProperties securityProperties;


    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request , HttpServletResponse response) throws IOException {
        ImageCode imageCode = imageCodeGenerator.createCode(new ServletWebRequest(request));
        //将随机数存在session中
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);

        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }

}
