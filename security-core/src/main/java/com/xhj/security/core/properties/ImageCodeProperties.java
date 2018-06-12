/**
 * 
 */
package com.xhj.security.core.properties;

/**
 * 图片验证码配置项
 * 
 * @author zhailiang
 *
 */
public class ImageCodeProperties extends SmsCodeProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	
	/**
	 * 图片宽
	 */
	private int width = 67;
	/**
	 * 图片高
	 */
	private int height = 23;

	private int length = 4;

	private int expireIn = 60;

	private String url;

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getExpireIn() {
		return expireIn;
	}

	@Override
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
