package com.ray.caipiao.ttffoff.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ray.caipiao.ttffoff.form.TtffoffForm;
import com.ray.caipiao.ttffoff.model.TtffCount;
import com.ray.caipiao.ttffoff.model.TtffData;
import com.ray.caipiao.ttffoff.model.TtffSum;

public interface TtffoffDao {

    public List<TtffData> query(@Param("form") TtffoffForm queryForm);

    public int queryCount(@Param("form") TtffoffForm queryForm);
    
    public List<TtffCount> queryCountData(@Param("form") TtffoffForm queryForm);
    
    @Select("select count(*) from ttff_data where ffid=#{ffid}")
    public int findTtffByIdCount(@Param("ffid") String ffid);

    @Insert("INSERT INTO ttff_data ( ffid, result,udate,year,month,dayid,d1,d2,d3,d4,d5 ) "
            + "VALUES( #{tt.ffid},#{tt.result},#{tt.udate},#{tt.year},#{tt.month},#{tt.dayid},#{tt.d1},#{tt.d2},#{tt.d3},#{tt.d4},#{tt.d5})")
    public int saveTtffData(@Param("tt") TtffData tt) throws Exception;

    /**
     * @param dnum
     *            表示获取哪一列
     */
    @Select("select tab1.${dnum},count(*) as count from "
            + "(select * from ttff_data tt where tt.ffid <=#{ffid} order by tt.ffid desc LIMIT 0,#{topnum} ) tab1 "
            + "group by tab1.${dnum}")
    public List<TtffSum> findTopN(@Param("dnum") String dnum, @Param("ffid") String ffid, @Param("topnum") int topnum);

    @Select("select count(*) from ttff_count where ffid=#{ffid}")
    public int findCountExist(@Param("ffid") String ffid);

    @Select("select * from ttff_group")
    public List<TtffCount> findAllGroup();

    @Insert("INSERT INTO ttff_count ( ffid, groupid,d1,d2,d3,d4,d5,udate ) "
            + "VALUES( #{c.ffid},#{c.groupid},#{c.d1},#{c.d2},#{c.d3},#{c.d4},#{c.d5},#{c.udate})")
    public void saveTtffCount(@Param("c") TtffCount c) throws Exception;
    
    @Select("select max(d1)-min(d1) as d1 ,max(d2)-min(d2) as d2 ,max(d3)-min(d3) as d3 ,max(d4)-min(d4) as d4 ,max(d5)-min(d5) as d5 from ttff_count where ffid=#{ffid}")
    public TtffCount findMailNum(@Param("ffid") String ffid );
}