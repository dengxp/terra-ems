package com.terra.home.domain.vo;

import lombok.Data;
import lombok.Getter;

/**
 * Name: HomeEnergyStatisticsNewVO
 * Email: dengxueping@gmail.com
 * Date: 2025-04-13
 * Description:
 *
 * @author dengxueping
 */

@Data
public class HomeEnergyStatisticsNewVO {

    private String energyNo;

    private String energyName;

    private String energyUnit;

    private Double count;

    //同比 ：Year on Year
    private Double yoy;

    // 环比：Month on Month
    private Double mom;

    // 等价折标系数
    private String coefficient;

    // 转换为吨标煤
    private Double tonCount;

}
