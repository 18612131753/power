package com.ray.caipiao.ttffoff.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.base.util.WebUtils;
import com.ray.caipiao.ttffoff.dao.TtffoffDao;
import com.ray.caipiao.ttffoff.model.OffoResult;
import com.ray.caipiao.ttffoff.model.TtffCount;
import com.ray.caipiao.ttffoff.model.TtffData;
import com.ray.caipiao.ttffoff.model.TtffSum;
import com.ray.publicserver.service.MailService;

@Service("ttffoffService")
public class TtffoffServiceImpl implements TtffoffService {

    private static Logger logger = LoggerFactory.getLogger(TtffoffServiceImpl.class);
    
    @Resource
    private TtffoffDao ttffoffDao;

    @Autowired  
    private MailService mailService;
    
    // 获取数据页面
    public static String URL = "http://www.off0.com/fenfencai.php";
    public static int TOPNUM = 300;
    public static int MAILNUM = 120 ;
    @Override
    public List<OffoResult> findUrlData() {
        String result = null;
        try {
            result = WebUtils.get(TtffoffServiceImpl.URL, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null)
            return null;
        // 抓取页面
        Pattern patternTr = Pattern.compile("<tr>.*?</tr>");
        Matcher matcherTr = patternTr.matcher(result);
        List<OffoResult> list = new ArrayList<OffoResult>();
        while (matcherTr.find()) {
            String tr = matcherTr.group();
            Pattern patternTd = Pattern.compile("<td>.*?</td>");
            Matcher matcherTd = patternTd.matcher(tr);
            int i = 0;
            OffoResult or = new OffoResult();
            String content = null;
            while (matcherTd.find()) {
                content = matcherTd.group().replaceAll("<td>", "").replaceAll("</td>", "");
                switch (i) {
                case 1:
                    or.setId(content.replaceAll("-", ""));
                    break;
                case 2:
                    or.setDate(content);
                    break;
                case 4:
                    or.setResult(content);
                    break;
                default:
                    break;
                }
                i++;
            }
            if (or != null && or.getId() != null)
                list.add(or);
        }
        return list;
    }

    @Override
    public void saveToSource(List<OffoResult> list) {
        for (OffoResult r : list) {
            try {
                TtffData tt = this.dataChange(r);
                if (ttffoffDao.findTtffByIdCount(tt.getFfid()) == 0) {
                    ttffoffDao.saveTtffData(tt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private TtffData dataChange(OffoResult r) throws Exception {
        TtffData tt = new TtffData();
        tt.setFfid(r.getId());
        tt.setResult(r.getResult());
        tt.setUdate(r.getDate());

        tt.setYear(r.getId().substring(0, 4));
        tt.setMonth(r.getId().substring(4, 8));
        tt.setDayid(r.getId().substring(8));

        String[] result = r.getResult().split(",");
        tt.setD1(Integer.valueOf(result[0]));
        tt.setD2(Integer.valueOf(result[1]));
        tt.setD3(Integer.valueOf(result[2]));
        tt.setD4(Integer.valueOf(result[3]));
        tt.setD5(Integer.valueOf(result[4]));

        return tt;
    }

    @Override
    public List<String> countNumData(List<OffoResult> list) {
        if (list == null || list.size() == 0)
            return null ;
        List<String> list_ffid = new ArrayList<String>();
        List<TtffCount> list_count = ttffoffDao.findAllGroup();
        for (OffoResult or : list) {
            // 3.1 判断这一期是否已经计算过
            if (ttffoffDao.findCountExist(or.getId()) > 0) continue;
            list_ffid.add(or.getId()); //插入期数之前，将集合返回
            // 3.2 如果没有计算过,进行统计
            List<TtffSum> list_d1 = ttffoffDao.findTopN("d1", or.getId(), TtffoffServiceImpl.TOPNUM);
            List<TtffSum> list_d2 = ttffoffDao.findTopN("d2", or.getId(), TtffoffServiceImpl.TOPNUM);
            List<TtffSum> list_d3 = ttffoffDao.findTopN("d3", or.getId(), TtffoffServiceImpl.TOPNUM);
            List<TtffSum> list_d4 = ttffoffDao.findTopN("d4", or.getId(), TtffoffServiceImpl.TOPNUM);
            List<TtffSum> list_d5 = ttffoffDao.findTopN("d5", or.getId(), TtffoffServiceImpl.TOPNUM);
            Date nowdata = new Date();
            for (TtffCount c : list_count) {
                c.setFfid(or.getId()); // 期号
                c.setUdate(nowdata);
                if (list_d1.size() >= 0) {
                    for (TtffSum tsum : list_d1) {
                        if (c.getResult().indexOf(tsum.getD1().toString()) >= 0) {
                            c.setD1(c.getD1() + tsum.getCount());
                        }
                    }
                }
                if (list_d2.size() >= 0) {
                    for (TtffSum tsum : list_d2) {
                        if (c.getResult().indexOf(tsum.getD2().toString()) >= 0) {
                            c.setD2(c.getD2() + tsum.getCount());
                        }
                    }
                }
                if (list_d3.size() >= 0) {
                    for (TtffSum tsum : list_d3) {
                        if (c.getResult().indexOf(tsum.getD3().toString()) >= 0) {
                            c.setD3(c.getD3() + tsum.getCount());
                        }
                    }
                }
                if (list_d4.size() >= 0) {
                    for (TtffSum tsum : list_d4) {
                        if (c.getResult().indexOf(tsum.getD4().toString()) >= 0) {
                            c.setD4(c.getD4() + tsum.getCount());
                        }
                    }
                }
                if (list_d5.size() >= 0) {
                    for (TtffSum tsum : list_d5) {
                        if (c.getResult().indexOf(tsum.getD5().toString()) >= 0) {
                            c.setD5(c.getD5() + tsum.getCount());
                        }
                    }
                }
                // 4. 保存数据
                try {
                    ttffoffDao.saveTtffCount(c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.setD1(0);
                c.setD2(0);
                c.setD3(0);
                c.setD4(0);
                c.setD5(0);
            }
        }
        logger.info( "返回");
        return list_ffid ;
    }

    @Override
    public void sendMail(List<String> ffid_list) {
        int bignum = TtffoffServiceImpl.MAILNUM ;
        StringBuilder sb = new StringBuilder();
        
        for( String ffid : ffid_list ){
            TtffCount tc = ttffoffDao.findMailNum(ffid) ;
            if( tc.getD1() >= bignum  ){
                sb.append( "第 "+ ffid + " 的 万位 数字满足条件：大于 "+ bignum + " 差值...");
            }
            if( tc.getD2() >= bignum  ){
                sb.append( "第 "+ ffid + " 的 千位 数字满足条件：大于 "+ bignum + " 差值...");
            }
            if( tc.getD3() >= bignum  ){
                sb.append( "第 "+ ffid + " 的 百位 数字满足条件：大于 "+ bignum + " 差值...");
            }
            if( tc.getD4() >= bignum  ){
                sb.append( "第 "+ ffid + " 的 十位 数字满足条件：大于 "+ bignum + " 差值...");
            }
            if( tc.getD5() >= bignum  ){
                sb.append( "第 "+ ffid + " 的 个位 数字满足条件：大于 "+ bignum + " 差值...");
            }
        }
        if( sb.toString().length() >0){
            mailService.sendSimpleMail("25905459@qq.com", "腾讯彩票友情提示：础亲，可以看看内容了", sb.toString());
        }
    }

}
