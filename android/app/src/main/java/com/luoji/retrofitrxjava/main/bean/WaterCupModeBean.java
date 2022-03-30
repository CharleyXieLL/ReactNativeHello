package com.luoji.retrofitrxjava.main.bean;

import java.util.List;

/**
 * Author:Ace
 * Date:On 2021/12/29
 */
public class WaterCupModeBean {
    private List<CustomModeSettingDTOBean> customModeSettingDTOList;
    private List<FixedModeDTOBean> fixedModeDTOList;

    public WaterCupModeBean() {
    }

    public WaterCupModeBean(List<CustomModeSettingDTOBean> customModeSettingDTOList, List<FixedModeDTOBean> fixedModeDTOList) {
        this.customModeSettingDTOList = customModeSettingDTOList;
        this.fixedModeDTOList = fixedModeDTOList;
    }

    public List<CustomModeSettingDTOBean> getCustomModeSettingDTOList() {
        return customModeSettingDTOList;
    }

    public void setCustomModeSettingDTOList(List<CustomModeSettingDTOBean> customModeSettingDTOList) {
        this.customModeSettingDTOList = customModeSettingDTOList;
    }

    public List<FixedModeDTOBean> getFixedModeDTOList() {
        return fixedModeDTOList;
    }

    public void setFixedModeDTOList(List<FixedModeDTOBean> fixedModeDTOList) {
        this.fixedModeDTOList = fixedModeDTOList;
    }
}
