package com.cll.pay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="wechat.pay")
@Component
public class WechatAccountConfig {
	private String mpAppId;//
	private String mchId;
	private String mchkey;
	private String keyPath;
	private String notifyUrl;
	public String getMpAppId() {
		return mpAppId;
	}
	public void setMpAppId(String mpAppId) {
		this.mpAppId = mpAppId;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getMchkey() {
		return mchkey;
	}
	public void setMchkey(String mchkey) {
		this.mchkey = mchkey;
	}
	public String getKeyPath() {
		return keyPath;
	}
	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
}
