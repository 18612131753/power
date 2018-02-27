package com.ray.caipiao.ttffoff.service;

import java.util.List;

import com.ray.caipiao.ttffoff.model.OffoResult;

public interface TtffoffService {

    /** 从网页获取数据 */
    public List<OffoResult> findUrlData();

    /** 获取数据库 */
    public void saveToSource(List<OffoResult> list);
    
    /** 计算当期统计 
     * @return 返回插入数据的期数的集合
     * */
    public List<String> countNumData(List<OffoResult> list);
    
    /**
     * 邮件系统
     * */
    public void sendMail (List<String> ffid_list);
}
