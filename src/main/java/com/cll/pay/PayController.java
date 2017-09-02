package com.cll.pay;


import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;

@RestController
@RequestMapping("")
public class PayController {
    @Autowired
    private BestPayServiceImpl bestService;

    //增加日志
    private static Logger log = LoggerFactory.getLogger(PayController.class);
    
    /**
     * go pay
     */
    @GetMapping("/pay")
    public ModelAndView pay(@RequestParam("openid") String openid,Map<String, Object> map){
    	PayRequest request = new PayRequest();
    	Random random = new Random();
    	
    	//pay request param
    	request.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
    	request.setOrderId("");
    	request.setOrderAmount(0.1);
    	request.setOrderName("cll");
    	request.setOpenid(openid);
    	log.info("[] request ={}",JsonUtil.toJson(request));
    	
    	//发起支付
    	PayResponse payResponse  = bestService.pay(request);
    	log.info("[] response={}");JsonUtil.toJson(payResponse);
    	map.put("PayResponse", payResponse);
    	return new ModelAndView("pay/create",map);
    	
    }
    
    /**
     * 异步回调
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) throws Exception{
    	log.info("[] requestData={}",notifyData);
    	//异步回调
    	PayResponse response = bestService.asyncNotify(notifyData);
    	log.info("[] response={}");JsonUtil.toJson(notifyData);
    	
    	return new ModelAndView("pay/success");
    	
    	
    }
  }