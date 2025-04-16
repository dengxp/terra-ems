package com.terra.keyequipment.service.impl;

import com.terra.keyequipment.domain.MonthlyKeyEquipment;
import com.terra.keyequipment.mapper.MonthlyKeyEquipmentMapper;
import com.terra.keyequipment.service.IMonthlyKeyEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *重点设备能耗统计 月
 *
 * @author sys
 * @date 2021-01-11
 */
@Service
public class MonthlyKeyEquipmentServiceImpl implements IMonthlyKeyEquipmentService {
    @Autowired
    private MonthlyKeyEquipmentMapper monthlyKeyEquipmentMapper;

    @Override
    public List<MonthlyKeyEquipment> getMonthlyKeyEquipmentList(List<String> indexIds, List<MonthlyKeyEquipment> dataList, Date beginTime, Date endTime, String timeType, String indexStorageId){
        if (indexIds != null && !indexIds.isEmpty()) {
            return monthlyKeyEquipmentMapper.getMonthlyKeyEquipmentList(indexIds, dataList, beginTime, endTime, timeType, indexStorageId);
        }
        return Collections.emptyList();
    }

    @Override
    public List<MonthlyKeyEquipment> getListChart(String indexId, Date beginTime, Date endTime, String timeType, String indexStorageId){
        if (indexId != null && !indexId.isEmpty()) {
            return monthlyKeyEquipmentMapper.getListChart(indexId,beginTime,endTime,timeType,indexStorageId);
        }
        return Collections.emptyList();
    }
}
