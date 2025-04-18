package com.terra.web.controller.homepage;

import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.consumptionanalysis.domain.vo.RankingEnergyData;
import com.terra.home.domain.vo.HomeEnergyConsumptionTrendVO;
import com.terra.home.domain.vo.HomePeakValleyVO;
import com.terra.home.service.IHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HomePageController
 *
 * @author hmj
 * @date 2024-10-08
 */
@RestController
@RequestMapping("/homepage")
public class HomePageController extends BaseController {

    @Autowired
    public IHomePageService homepageService;

    /**
     * &#064;description:  全厂能耗统计
     */
    @GetMapping("/energyConsumptionSummation")
    public AjaxResult energyConsumptionSummation(String timeType) {
        try {
            String modelCode = "COMPREHENSIVE_CODE";
            return AjaxResult.success(homepageService.energyConsumptionSummation(timeType, modelCode));
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }


    /**
     * @description: 能耗趋势
     * @author: hmj
     * @date: 2024/10/8 13:41
     */
    @GetMapping("/energyConsumptionTrend")
    public AjaxResult energyConsumptionTrend(String timeType) {
        try {
            String modelcode = "COMPREHENSIVE_CODE";
            HomeEnergyConsumptionTrendVO vo = homepageService.energyConsumptionTrend(timeType, modelcode);

            return AjaxResult.success(vo);
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }

    /**
     * @description: 科室能耗排名
     * @author: hmj
     * @date: 2024/10/8 13:41
     */
    @GetMapping("/energyConsumptionRanking")
    public AjaxResult energyConsumptionRanking(String timeType) {
        try {
            String modelcode = "COMPREHENSIVE_CODE";
            List<RankingEnergyData> consumptionAnalysisVO = homepageService.energyConsumptionRanking(modelcode, timeType);
            return AjaxResult.success(consumptionAnalysisVO);
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }

    /**
     * @description: 峰平谷占比
     * @author: hmj
     * @date: 2024/10/8 13:41
     */
    @GetMapping("/peakValley")
    public AjaxResult peakValley(String timeType) {
        try {
            String modelcode = "COMPREHENSIVE_CODE";
            List<HomePeakValleyVO> vo = homepageService.peakValley(timeType, modelcode);
            return AjaxResult.success(vo);
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }
}
