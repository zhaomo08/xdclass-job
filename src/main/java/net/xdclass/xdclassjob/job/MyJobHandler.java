package net.xdclass.xdclassjob.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D，微信：xdclass6
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Component
public class MyJobHandler {

    private Logger log = LoggerFactory.getLogger(MyJobHandler.class);

    @XxlJob(value = "demoJobHandler",init = "init",destroy = "destroy")
    public ReturnT<String> execute(String param){


        log.info(" execute 任务触发成功:"+LocalDateTime.now());
        XxlJobHelper.log("XXL-JOB, Hello World：{}", param);


        return ReturnT.SUCCESS;
    }


    private void  init(){
        log.info("init 方法调用成功");
    }

    private void destroy(){
        log.info("destroy 方法调用成功");
    }

}
