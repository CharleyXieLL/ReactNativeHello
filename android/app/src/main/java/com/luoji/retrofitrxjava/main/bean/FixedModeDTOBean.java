package com.luoji.retrofitrxjava.main.bean;

/**
 * Author:Ace
 * Date:On 2021/12/29
 */
public class FixedModeDTOBean {
    private String createdAt;
    private String greenIconUrl;
    private String greyIconUrl;
    private long id;
    private String name;
    private String redIconUrl;
    private int setTemperature;
    private String updatedAt;
    private String yellowIconUrl;

    public FixedModeDTOBean() {
        
    }

    public FixedModeDTOBean(String createdAt, String greenIconUrl, String greyIconUrl, long id, String name, String redIconUrl, int setTemperature, String updatedAt, String yellowIconUrl) {
        this.createdAt = createdAt;
        this.greenIconUrl = greenIconUrl;
        this.greyIconUrl = greyIconUrl;
        this.id = id;
        this.name = name;
        this.redIconUrl = redIconUrl;
        this.setTemperature = setTemperature;
        this.updatedAt = updatedAt;
        this.yellowIconUrl = yellowIconUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGreenIconUrl() {
        return greenIconUrl;
    }

    public void setGreenIconUrl(String greenIconUrl) {
        this.greenIconUrl = greenIconUrl;
    }

    public String getGreyIconUrl() {
        return greyIconUrl;
    }

    public void setGreyIconUrl(String greyIconUrl) {
        this.greyIconUrl = greyIconUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedIconUrl() {
        return redIconUrl;
    }

    public void setRedIconUrl(String redIconUrl) {
        this.redIconUrl = redIconUrl;
    }

    public int getSetTemperature() {
        return setTemperature;
    }

    public void setSetTemperature(int setTemperature) {
        this.setTemperature = setTemperature;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getYellowIconUrl() {
        return yellowIconUrl;
    }

    public void setYellowIconUrl(String yellowIconUrl) {
        this.yellowIconUrl = yellowIconUrl;
    }
}
