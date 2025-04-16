package com.terra.home.service;

import com.terra.consumptionanalysis.domain.vo.RankingEnergyData;
import com.terra.home.domain.vo.HomeEnergyConsumptionTrendVO;
import com.terra.home.domain.vo.HomeEnergyStatisticsVO;
import com.terra.home.domain.vo.HomePeakValleyVO;

import java.util.List;

/**
 * description todu
 *
 * @author hmj
 * date 2024-10-31 18:07
 */
public interface IHomePageService {
    List<HomeEnergyStatisticsVO> energyConsumptionSummation(String timeType, String modelCode);

    List<HomePeakValleyVO> peakValley(String timeType, String modelCode);

    HomeEnergyConsumptionTrendVO energyConsumptionTrend(String timeType, String modelCode);

    List<RankingEnergyData> energyConsumptionRanking(String modelCode, String timeType);
}
