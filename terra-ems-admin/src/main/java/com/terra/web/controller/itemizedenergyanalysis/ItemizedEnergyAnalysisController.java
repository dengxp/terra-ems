package com.terra.web.controller.itemizedenergyanalysis;

import com.terra.Itemizedenergyanalysis.domain.VO.ItemizedEnergyAnalysisVO;
import com.terra.Itemizedenergyanalysis.dto.ItemizedEnergyAnalysisDTO;
import com.terra.Itemizedenergyanalysis.service.IItemizedEnergyAnalysisService;
import com.terra.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.terra.common.core.domain.AjaxResult.success;

/**
 * 分项用能分析 接口
 */
@RestController
@RequestMapping("/itemizedEnergyAnalysis")
@Api(value = "分项用能分析", tags = {"分项用能分析"})
public class ItemizedEnergyAnalysisController {

    @Autowired
    private IItemizedEnergyAnalysisService itemizedEnergyAnalysisService;

    /**
     *
     * @param dataItem
     * @return
     */
    @GetMapping("/list")
    private AjaxResult list(ItemizedEnergyAnalysisDTO dataItem) {
        ItemizedEnergyAnalysisVO list = itemizedEnergyAnalysisService.getItemizedEnergyAnalysisService(dataItem);
        return success(list);
    }
}