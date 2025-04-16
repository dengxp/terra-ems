package com.terra.processenergy.service;

import com.terra.common.utils.TypeTime;
import com.terra.processenergy.domain.YearProcessEnergy;
import com.terra.realtimedata.domain.dto.DataItemQueryDTO;

import java.util.Date;
import java.util.List;

/**
 *工序能耗 日
 *
 * @author sys
 * @date 2021-01-11
 */
public interface IYearProcessEnergyService {

    List<YearProcessEnergy> getYearProcessEnergy(List<String> indexIds, List<TypeTime> dataList, Date beginTime, Date endTime, String timeType, String indexStorageId);

    /**
     *
     * @param queryDto
     * @return
     */
    List<YearProcessEnergy> getListChart(DataItemQueryDTO queryDto);
}
