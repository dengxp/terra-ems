package com.terra.processenergy.service.impl;

import com.terra.common.enums.TimeType;
import com.terra.processenergy.domain.MonthlyProcessEnergy;
import com.terra.processenergy.mapper.MonthlyProcessEnergyMapper;
import com.terra.processenergy.service.IMonthlyProcessEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 *重点设备能耗统计 日
 *
 * @author sys
 * @date 2021-01-11
 */
@Service
public class MonthlyProcessEnergyServiceImpl implements IMonthlyProcessEnergyService {

    @Resource
    private MonthlyProcessEnergyMapper monthlyProcessEnergyMapper;

    @Override
    public List<MonthlyProcessEnergy> getMonthlyProcessEnergy(List<String> indexIds, List<MonthlyProcessEnergy> dataList, Date beginTime, Date endTime, String timeType, String indexStorageId){
        if (indexIds != null && !indexIds.isEmpty()){
            return monthlyProcessEnergyMapper.getMonthlyProcessEnergy(indexIds, dataList, beginTime, endTime, timeType, indexStorageId);
        }
        return Collections.emptyList();
    }

    @Override
    public List<MonthlyProcessEnergy> getListChart(String indexId, Date beginTime, Date endTime, String timeType, String indexStorageId){
        if (indexId != null && !indexId.isEmpty()) {
            return monthlyProcessEnergyMapper.getListChart(indexId,beginTime,endTime,timeType,indexStorageId);
        }
        return Collections.emptyList();
    }
}
