/**
 * 
 */
package com.xhj.security.core.validate.code.image;

import com.xhj.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import com.xhj.security.core.validate.code.ValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 图片验证码处理器
 * 
 * @author zhailiang
 *
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * 发送图形验证码，将其写到响应中
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {

		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}
}
