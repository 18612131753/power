package com.ray.caipiao.ttffoff.model;

public class TtffGroup {

    private String groupid;
    private String result;
    private String start_ffid; // 开始期数

    // 万位
    private double d1_x = 0;
    private String d1_x_ffid; // 本期期号N

    private double d1_y = -10; // 初始值设置小一些，这样第一个数据就是最大值
    private String d1_y_ffid; // 记录当前波峰所在的期号记作P,即y发生的期数

    private double d1_z = 0; // z=x-y
    private int d1_z_ffid = 0; // d1_y_ffid - d1_x_ffid
    
    // 千位
    private double d2_x = 0;
    private String d2_x_ffid; // 本期期号N

    private double d2_y = -10; // 初始值设置小一些，这样第一个数据就是最大值
    private String d2_y_ffid; // 记录当前波峰所在的期号记作P,即y发生的期数

    private double d2_z = 0; // z=x-y
    private int d2_z_ffid = 0; 
    
    // 百位
    private double d3_x = 0;
    private String d3_x_ffid; // 本期期号N

    private double d3_y = -10; // 初始值设置小一些，这样第一个数据就是最大值
    private String d3_y_ffid; // 记录当前波峰所在的期号记作P,即y发生的期数

    private double d3_z = 0; // z=x-y
    private int d3_z_ffid = 0;
    // 十位
    private double d4_x = 0;
    private String d4_x_ffid; // 本期期号N

    private double d4_y = -10; // 初始值设置小一些，这样第一个数据就是最大值
    private String d4_y_ffid; // 记录当前波峰所在的期号记作P,即y发生的期数

    private double d4_z = 0; // z=x-y
    private int d4_z_ffid = 0;
    // 个位
    private double d5_x = 0;
    private String d5_x_ffid; // 本期期号N

    private double d5_y = -10; // 初始值设置小一些，这样第一个数据就是最大值
    private String d5_y_ffid; // 记录当前波峰所在的期号记作P,即y发生的期数

    private double d5_z = 0; // z=x-y
    private int d5_z_ffid = 0;
    
    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getD1_x() {
        return d1_x;
    }

    public void setD1_x(double d1_x) {
        this.d1_x = d1_x;
    }

    public double getD1_y() {
        return d1_y;
    }

    public void setD1_y(double d1_y) {
        this.d1_y = d1_y;
    }

    public double getD1_z() {
        return d1_z;
    }

    public void setD1_z(double d1_z) {
        this.d1_z = d1_z;
    }

    public String getD1_x_ffid() {
        return d1_x_ffid;
    }

    public void setD1_x_ffid(String d1_x_ffid) {
        this.d1_x_ffid = d1_x_ffid;
    }

    public String getD1_y_ffid() {
        return d1_y_ffid;
    }

    public void setD1_y_ffid(String d1_y_ffid) {
        this.d1_y_ffid = d1_y_ffid;
    }

    public String getStart_ffid() {
        return start_ffid;
    }

    public void setStart_ffid(String start_ffid) {
        this.start_ffid = start_ffid;
    }

    public double getD2_x() {
        return d2_x;
    }

    public void setD2_x(double d2_x) {
        this.d2_x = d2_x;
    }

    public String getD2_x_ffid() {
        return d2_x_ffid;
    }

    public void setD2_x_ffid(String d2_x_ffid) {
        this.d2_x_ffid = d2_x_ffid;
    }

    public double getD2_y() {
        return d2_y;
    }

    public void setD2_y(double d2_y) {
        this.d2_y = d2_y;
    }

    public String getD2_y_ffid() {
        return d2_y_ffid;
    }

    public void setD2_y_ffid(String d2_y_ffid) {
        this.d2_y_ffid = d2_y_ffid;
    }

    public double getD2_z() {
        return d2_z;
    }

    public void setD2_z(double d2_z) {
        this.d2_z = d2_z;
    }

    public double getD3_x() {
        return d3_x;
    }

    public void setD3_x(double d3_x) {
        this.d3_x = d3_x;
    }

    public String getD3_x_ffid() {
        return d3_x_ffid;
    }

    public void setD3_x_ffid(String d3_x_ffid) {
        this.d3_x_ffid = d3_x_ffid;
    }

    public double getD3_y() {
        return d3_y;
    }

    public void setD3_y(double d3_y) {
        this.d3_y = d3_y;
    }

    public String getD3_y_ffid() {
        return d3_y_ffid;
    }

    public void setD3_y_ffid(String d3_y_ffid) {
        this.d3_y_ffid = d3_y_ffid;
    }

    public double getD3_z() {
        return d3_z;
    }

    public void setD3_z(double d3_z) {
        this.d3_z = d3_z;
    }

    public double getD4_x() {
        return d4_x;
    }

    public void setD4_x(double d4_x) {
        this.d4_x = d4_x;
    }

    public String getD4_x_ffid() {
        return d4_x_ffid;
    }

    public void setD4_x_ffid(String d4_x_ffid) {
        this.d4_x_ffid = d4_x_ffid;
    }

    public double getD4_y() {
        return d4_y;
    }

    public void setD4_y(double d4_y) {
        this.d4_y = d4_y;
    }

    public String getD4_y_ffid() {
        return d4_y_ffid;
    }

    public void setD4_y_ffid(String d4_y_ffid) {
        this.d4_y_ffid = d4_y_ffid;
    }

    public double getD4_z() {
        return d4_z;
    }

    public void setD4_z(double d4_z) {
        this.d4_z = d4_z;
    }

    public double getD5_x() {
        return d5_x;
    }

    public void setD5_x(double d5_x) {
        this.d5_x = d5_x;
    }

    public String getD5_x_ffid() {
        return d5_x_ffid;
    }

    public void setD5_x_ffid(String d5_x_ffid) {
        this.d5_x_ffid = d5_x_ffid;
    }

    public double getD5_y() {
        return d5_y;
    }

    public void setD5_y(double d5_y) {
        this.d5_y = d5_y;
    }

    public String getD5_y_ffid() {
        return d5_y_ffid;
    }

    public void setD5_y_ffid(String d5_y_ffid) {
        this.d5_y_ffid = d5_y_ffid;
    }

    public double getD5_z() {
        return d5_z;
    }

    public void setD5_z(double d5_z) {
        this.d5_z = d5_z;
    }

    public int getD1_z_ffid() {
        return d1_z_ffid;
    }

    public void setD1_z_ffid(int d1_z_ffid) {
        this.d1_z_ffid = d1_z_ffid;
    }

    public int getD2_z_ffid() {
        return d2_z_ffid;
    }

    public void setD2_z_ffid(int d2_z_ffid) {
        this.d2_z_ffid = d2_z_ffid;
    }

    public int getD3_z_ffid() {
        return d3_z_ffid;
    }

    public void setD3_z_ffid(int d3_z_ffid) {
        this.d3_z_ffid = d3_z_ffid;
    }

    public int getD4_z_ffid() {
        return d4_z_ffid;
    }

    public void setD4_z_ffid(int d4_z_ffid) {
        this.d4_z_ffid = d4_z_ffid;
    }

    public int getD5_z_ffid() {
        return d5_z_ffid;
    }

    public void setD5_z_ffid(int d5_z_ffid) {
        this.d5_z_ffid = d5_z_ffid;
    }

}
