package com.duruijuan.pojo;

import javax.persistence.*;

public class Orders {
    @Id
    private Integer id;

    private Integer userid;

    private Integer menuid;

    private Integer menusum;

    private String times;

    private Integer delivery;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return menuid
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * @param menuid
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * @return menusum
     */
    public Integer getMenusum() {
        return menusum;
    }

    /**
     * @param menusum
     */
    public void setMenusum(Integer menusum) {
        this.menusum = menusum;
    }

    /**
     * @return times
     */
    public String getTimes() {
        return times;
    }

    /**
     * @param times
     */
    public void setTimes(String times) {
        this.times = times;
    }

    /**
     * @return delivery
     */
    public Integer getDelivery() {
        return delivery;
    }

    /**
     * @param delivery
     */
    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }
}