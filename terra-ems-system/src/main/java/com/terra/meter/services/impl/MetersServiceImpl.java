package com.terra.meter.services.impl;

import com.terra.meter.domain.MeterConfig;
import com.terra.meter.domain.MeterImplements;
import com.terra.meter.domain.MeterParam;
import com.terra.meter.mapper.MetersMapper;
import com.terra.meter.services.IMetersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: MeterImplementServiceImpl
 * @Author: Yarry
 * @CreateTime: 2024-09-20 16-22-19
 * @Description: TODO
 * @Version: 1.0
 * @Since: JDK1.8
 */

@Service
public class MetersServiceImpl implements IMetersService {

    @Resource
    private MetersMapper metersMapper;


    /**
     * 获取所有计量表数据
     * @return
     */
    @Override
    public List<MeterImplements> listMeterData(String meterType) {
        return metersMapper.listMeterData(meterType);
    }

    /**
     * 获取点位配置数据
     *
     * @return
     */
    @Override
    public List<MeterParam> listConfigurationData(String meterType, String indexType) {
        return metersMapper.listConfigurationData(meterType, indexType);
    }

    /**
     * 获取点位code配置数据
     *
     * @param indexType
     * @return
     */
    @Override
    public List<MeterConfig> listConfigData(String indexType) {
        return metersMapper.listConfigData(indexType);
    }
}
