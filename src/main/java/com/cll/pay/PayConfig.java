package com.cll.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;

@Component
public class PayConfig {
	@Autowired
	private WechatAccountConfig accountConfig;
	
	@Bean
	public WxPayH5Config wxPayH5Config(){
		//微信公众账号支付配置
		WxPayH5Config wxPayH5Config = new WxPayH5Config();
		wxPayH5Config.setAppId(accountConfig.getMpAppId());
		wxPayH5Config.setMchId(accountConfig.getMchId());
		wxPayH5Config.setMchKey(accountConfig.getMchkey());
		wxPayH5Config.setKeyPath(accountConfig.getKeyPath());
		wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());
		
		
		return wxPayH5Config;
	}
	
	@Bean
	public BestPayServiceImpl bestPayService(WxPayH5Config wxPayH5Config){
		////支付类, 所有方法都在这个类里
		BestPayServiceImpl bestPayService = new BestPayServiceImpl();
		bestPayService.setWxPayH5Config(wxPayH5Config);
		return bestPayService;
	}
	
}
