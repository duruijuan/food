package com.duruijuan.pojo;

import javax.persistence.*;

public class Category {
    @Column(name = "CategoryID")
    private Integer categoryid;

    @Column(name = "CategoryName")
    private String categoryname;

    /**
     * @return CategoryID
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return CategoryName
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * @param categoryname
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}