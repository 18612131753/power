package com.ray.caipiao.ttffoff.service;

import java.util.List;

import com.ray.base.util.GridDataModel;
import com.ray.caipiao.ttffoff.form.TtffoffForm;
import com.ray.caipiao.ttffoff.model.OffoResult;
import com.ray.caipiao.ttffoff.model.TtffCount;
import com.ray.caipiao.ttffoff.model.TtffData;
import com.ray.caipiao.ttffoff.model.TtffGroup;

public interface TtffoffService {

    /** 每期数据分页 */
    public GridDataModel<TtffData> query(TtffoffForm form);
    
    /** 分析数据，不分页  */
    public GridDataModel<TtffCount> querycount(TtffoffForm form);
    
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
    
    /**
     * 根据需求二，计算指数差，期数差
     * */
    public GridDataModel<TtffGroup> zhishuz(String startffid ,String endffid);
    
    public String findMaxFfid();
    
    public void deleteCountData(String ffid);
}
