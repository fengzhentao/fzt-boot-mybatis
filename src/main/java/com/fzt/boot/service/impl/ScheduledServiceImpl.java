package com.fzt.boot.service.impl;

import com.fzt.boot.service.ScheduledService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description 定时服务实现
 * @Author fengzt
 * @Date 2019/3/31
 **/
@Component
public class ScheduledServiceImpl implements ScheduledService {



    @Override
    @Scheduled(cron = "*/6 * * * * ?") //上一次开始执行时间点之后6秒再执行
//    @Scheduled(fixedRate = 6000) //上一次开始执行时间点之后6秒再执行
//    @Scheduled(fixedDelay = 6000) //上一次执行完毕时间点之后6秒再执行
//    @Scheduled(initialDelay = 6000, fixedRate = 6000) //第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执
    public void scheduledTest() {
        System.out.println("test 定时任务 " + System.currentTimeMillis());
    }
}
