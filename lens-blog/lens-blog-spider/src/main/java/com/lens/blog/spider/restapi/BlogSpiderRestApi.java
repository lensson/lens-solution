package com.lens.blog.spider.restapi;


import com.lens.blog.spider.pipeline.BlogPipeline;
import com.lens.blog.spider.processer.BlogProcesser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * <p>
 * 博客爬取RestApi
 * </p>
 *
 * @author Lens
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

    private Spider largeSpider;

    /**
     * 爬取参数传进来的网站的数据
     *
     * @return
     */
    @ApiOperation(value = "startSpider", notes = "startSpider")
    @RequestMapping(value = "/startSpider", method = RequestMethod.GET)
    public String startSpider(@ApiParam(name = "url", value = "想爬取的网站") @RequestParam("url") String url) {

        if (largeSpider != null) {
            largeSpider.addUrl(url);
            largeSpider.run();
            return "启动爬取";
        }
        //开启蜘蛛爬取内容
        largeSpider = Spider.create(blogProcesser)
                .addUrl(url)
                .addPipeline(blogPipeline)
                .setScheduler(new QueueScheduler())
                .thread(10);

        largeSpider.start();

        return "开始爬取";
    }

    /**
     * 爬取任意博客
     *
     * @return
     */
    @ApiOperation(value = "stopSpider", notes = "stopSpider")
    @RequestMapping(value = "/stopSpider", method = RequestMethod.GET)
    public String stopSpider() {

        //关闭蜘蛛爬取内容
        largeSpider.stop();

        return "关闭爬虫";
    }

    /**
     * 爬取csdn博客
     *
     * @return
     */
    @ApiOperation(value = "startSpiderCsdn", notes = "startSpiderCsdn")
    @RequestMapping(value = "/startSpiderCsdn", method = RequestMethod.GET)
    public String startSpiderCsdn() {

        if (spider != null) {
            spider.addUrl("https://www.csdn.net/");
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

