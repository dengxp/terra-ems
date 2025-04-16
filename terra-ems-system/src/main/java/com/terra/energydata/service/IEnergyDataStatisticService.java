package com.terra.energydata.service;


import com.terra.consumptionanalysis.domain.vo.RankingEnergyData;
import com.terra.energydata.vo.EnergyChainYoyVO;
import com.terra.energydata.vo.FactoryEnergyConsumptionVo;
import com.terra.energydata.vo.PurchaseConsumptionVo;
import com.terra.peakvalley.domain.dto.PeakValleyDTO;
import com.terra.peakvalley.domain.vo.peakvalley.PeakValleyDayVO;
import com.terra.peakvalley.domain.vo.peakvalley.PeakValleyHourVO;

import java.util.List;

public interface IEnergyDataStatisticService {
  PeakValleyDayVO segmentAnalysisMonth(PeakValleyDTO dto);

  List<RankingEnergyData> energyConsumptionRanking(String modelCode, String timeType);

  FactoryEnergyConsumptionVo factoryEnergyConsumption(String timeType, String modelCode);

  List<PurchaseConsumptionVo> purchaseConsumption(String modelCode, String timeType );

  List<PurchaseConsumptionVo> costProp(String modelCode, String timeType);

  List<EnergyChainYoyVO> energyConsumptionSummation(String timeType, String modelCode);

  PeakValleyDayVO segmentAnalysisDay(PeakValleyDTO dto);

  PeakValleyHourVO segmentAnalysisHour(PeakValleyDTO dto);
}
