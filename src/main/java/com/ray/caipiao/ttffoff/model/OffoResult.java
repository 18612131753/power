package com.ray.caipiao.ttffoff.model;

//http://www.off0.com
public class OffoResult {

    private String date;   //时间
    private String result; //结果
    private String id;   //期号

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return this.id +" "+this.result +" "+this.date ;
    }
}
