package com.terra.energydata.mapper;

import com.terra.model.domain.vo.ModelNodeIndexInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EnergyDataStatisticMapper
{
    List<ModelNodeIndexInfo> getModelNodeIndexIdByFixedNodeIds(@Param("modelCode")String modelCode, @Param("fixedNodeIds") List<String> fixedNodeIds);
}
