package com.terra.statisticalAnalysis.domain.vo;


import lombok.Data;

import java.math.BigDecimal;

/**
 * 数据分析同比 返回vo
 *
 * @Author: Zhujw
 * @Date: 2023/3/3
 */
@Data
public class DataAnalysisYoYVO {


    /**
     * 单位
     */
    private String unit;

    /**
     * 用能单元名称
     */
    private String energyUnitName;

    /**
     * 本期值
     */
    private BigDecimal currentValue;

    /**
     * 同期值
     */
    private BigDecimal oldValue;

    /**
     * 同比值
     */
    private BigDecimal ratio;
}
