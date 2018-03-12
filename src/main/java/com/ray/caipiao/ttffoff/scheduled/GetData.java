package com.ray.caipiao.ttffoff.scheduled;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ray.base.util.RayDateUtils;
import com.ray.caipiao.ttffoff.model.OffoResult;
import com.ray.caipiao.ttffoff.service.TtffoffService;

@Component
public class GetData {

    private static Logger logger = LoggerFactory.getLogger(GetData.class);

    @Resource(name = "ttffoffService")
    private TtffoffService ttffoffService;

    @Scheduled(cron = "40 * * * * ?")
    // 间隔60秒 @Scheduled(fixedDelay = 60000)
    public void getMinuteData() {
        logger.info( RayDateUtils.dateToStr(new Date()) +" start TTFFOff");
        // 1. 获取数据
        List<OffoResult> list = ttffoffService.findUrlData();
        if (list == null) {
            // 5秒钟重新尝试
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                list = ttffoffService.findUrlData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 2. 将数据结果存入数据库
        ttffoffService.saveToSource(list);
        
        // 3. 计算统计情况
        List<String> ffid_list = ttffoffService.countNumData(list);

        // 4. 根据插入的数据，判断是否应该邮件提醒
        ttffoffService.sendMail( ffid_list );
    }

    @Scheduled(cron = "0 10 0 * * ?")
    // 每天0点10分钟执行
    public void deleteCountData() {
        logger.info( RayDateUtils.dateToStr(new Date()) +" start deleteCountData");
        Date today = new Date();
        String today_s = RayDateUtils.dateToStr("yyyyMMdd",today)+"0001";
        ttffoffService.deleteCountData( today_s );
    }
}
