package com.lens.blog.sms.listener;


import com.lens.blog.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听器【用于发送短信】
 *
 * @author Lens
 * @date 2020年10月6日10:09:30
 */
@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @RabbitListener(queues = "lens.sms")
    public void sendSms(Map<String, String> map) {
        //TODO 短信发送暂时不用
//        try {
//            SendSmsResponse response = smsUtil.sendSms(
//                    map.get("mobile"),
//                    map.get("template_code"),
//                    map.get("sign_name"),
//                    map.get("param"));
//            System.out.println("code:" + response.getCode());
//            System.out.println("message:" + response.getMessage());
//
//        } catch (ClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
