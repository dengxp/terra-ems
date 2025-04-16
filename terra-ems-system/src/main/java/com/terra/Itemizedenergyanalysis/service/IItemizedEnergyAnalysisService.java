package com.terra.Itemizedenergyanalysis.service;

import com.terra.Itemizedenergyanalysis.domain.VO.ItemizedEnergyAnalysisVO;
import com.terra.Itemizedenergyanalysis.dto.ItemizedEnergyAnalysisDTO;

public interface IItemizedEnergyAnalysisService {
    /**
     * 分项用能分析
     * @param dto   请求参数
     * @return 结果
     */
    ItemizedEnergyAnalysisVO getItemizedEnergyAnalysisService(ItemizedEnergyAnalysisDTO dto);
}
