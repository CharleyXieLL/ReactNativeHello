package com.luoji.rnhello.main.bean;

/**
 * Author:Ace
 * Date:On 2021/12/29
 */
public class CustomModeSettingDTOBean {
    
    private boolean currentFlag;
    private String decVal;
    private String deviceId;
    private String deviceModelId;
    private String deviceTypeId;
    private String hexVal;
    private String iaAddr;
    private String id;
    private String name;
    private int setTemperature;

    public CustomModeSettingDTOBean() {
        
    }

    public CustomModeSettingDTOBean(boolean currentFlag, String decVal, String deviceId, String deviceModelId, String deviceTypeId, String hexVal, String iaAddr, String id, String name, int setTemperature) {
        this.currentFlag = currentFlag;
        this.decVal = decVal;
        this.deviceId = deviceId;
        this.deviceModelId = deviceModelId;
        this.deviceTypeId = deviceTypeId;
        this.hexVal = hexVal;
        this.iaAddr = iaAddr;
        this.id = id;
        this.name = name;
        this.setTemperature = setTemperature;
    }

    public boolean isCurrentFlag() {
        return currentFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    public String getDecVal() {
        return decVal;
    }

    public void setDecVal(String decVal) {
        this.decVal = decVal;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(String deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getHexVal() {
        return hexVal;
    }

    public void setHexVal(String hexVal) {
        this.hexVal = hexVal;
    }

    public String getIaAddr() {
        return iaAddr;
    }

    public void setIaAddr(String iaAddr) {
        this.iaAddr = iaAddr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSetTemperature() {
        return setTemperature;
    }

    public void setSetTemperature(int setTemperature) {
        this.setTemperature = setTemperature;
    }
}
