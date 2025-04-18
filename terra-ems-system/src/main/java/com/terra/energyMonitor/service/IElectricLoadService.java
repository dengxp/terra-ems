package com.terra.energyMonitor.service;

import com.terra.energyMonitor.domain.vo.ListElectricLoadVO;
import com.terra.energyMonitor.domain.vo.ListElectricityMeterVO;
import com.terra.model.domain.EnergyIndex;

import java.util.List;

/**
 * @Description:
 * @Author: jeecg-boot
 * @Date: 2022-04-19
 * @Version: V1.0
 */
public interface IElectricLoadService {

    /**
     * 获取负荷分析数据
     */
    ListElectricLoadVO list(String timeType, String timeCode, EnergyIndex energyIndex, String meterId);

    /**
     * 获取节点下所有电表
     * @param nodeId
     * @return
     */
    List<ListElectricityMeterVO> listElectricMeter(String nodeId);
}
