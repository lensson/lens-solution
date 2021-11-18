package com.lens.blog.sms.restapi;

import com.lens.blog.sms.util.SendMailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lens Chen
 * @created 2021-11-18 下午3:47
 * @Description Mail Rest API
 */

@RestController
@RequestMapping("/mail")
@Api(value = "邮件相关接口", tags = {"邮件相关接口"})
@Slf4j
public class MailRestApi {

    @Autowired
    private SendMailUtils sendMailUtils;

    /**
     * 发送邮件
     */
    @ApiOperation(value = "发送邮件", notes = "发送邮件")
    @GetMapping("/send")
    public String send(@RequestParam("receiver") String receiver, @RequestParam("text") String text) {

        log.info("发送邮件 给 " + receiver);
        sendMailUtils.sendEmail(receiver,text);
        return "邮件发送成功";
    }
}
