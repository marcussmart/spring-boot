package com.ken.spring.boot.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class City implements Serializable {
    private static final long serialVersionUID = 8993247077090375637L;

    /*
     * id
     */
    private Integer id;

    /*
     * 名称
     */
    private String name;

    /*
     * 地区
     */
    private String state;

    /*
     * 国家
     */
    private String country;

    /*
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", state=").append(state);
        sb.append(", country=").append(country);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}