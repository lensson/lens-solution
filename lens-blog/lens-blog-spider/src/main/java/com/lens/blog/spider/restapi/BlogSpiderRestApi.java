package com.lens.blog.spider.restapi;


import com.lens.blog.spider.pipeline.BlogPipeline;
import com.lens.blog.spider.processer.BlogProcesser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * <p>
 * 博客爬取RestApi
 * </p>
 *
 * @author 陌溪
 * @since 2020年2月8日11:02:09
 */
@RestController
@RequestMapping("/spider")
@Api(value = "博客爬取RestApi", tags = {"BlogSpiderRestApi"})
@Slf4j
public class BlogSpiderRestApi {

    @Autowired
    private BlogProcesser blogProcesser;

    @Autowired
    private BlogPipeline blogPipeline;

    private Spider spider;

    /**
     * 爬取csdn博客
     *
     * @return
     */
    @ApiOperation(value = "startSpiderCsdn", notes = "startSpiderCsdn")
    @RequestMapping(value = "/startSpiderCsdn", method = RequestMethod.GET)
    public String startSpiderCsdn() {

        if (spider != null) {
            spider.run();
            return "启动爬取";
        }
        //开启蜘蛛爬取内容
        spider = Spider.create(blogProcesser)
                .addUrl("https://www.csdn.net/")
                .addPipeline(blogPipeline)
                .setScheduler(new QueueScheduler())
                .thread(10);

        spider.start();

        return "开始爬取";
    }

    /**
     * 爬取csdn博客
     *
     * @return
     */
    @ApiOperation(value = "stopSpiderCsdn", notes = "stopSpiderCsdn")
    @RequestMapping(value = "/stopSpiderCsdn", method = RequestMethod.GET)
    public String stopSpiderCsdn() {

        //关闭蜘蛛爬取内容
        spider.stop();

        return "关闭爬虫";
    }
}

