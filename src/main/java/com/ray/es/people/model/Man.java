package com.ray.es.people.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * index 配置必须是全部小写，不然会异常
 */
@Document(indexName = "people", type = "man")
public class Man implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String country;
    @Field
    private Integer age;
    @Field
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
