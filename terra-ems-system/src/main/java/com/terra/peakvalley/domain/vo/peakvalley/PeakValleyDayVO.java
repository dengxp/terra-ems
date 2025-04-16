package com.terra.peakvalley.domain.vo.peakvalley;

import com.terra.home.domain.vo.HomeEnergyConsumptionTrendVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hmj
 * @date 2024-09-24 15:59
 */
@Getter
@Setter
public class PeakValleyDayVO {
    List<PeakValleyLineChatVO> costList;
    List<PeakValleyLineChatVO> powerConsumptionList;
    PeakValleyDayTotalVO totalVO;

    HomeEnergyConsumptionTrendVO costNewList;

    HomeEnergyConsumptionTrendVO powerNewList;
}
