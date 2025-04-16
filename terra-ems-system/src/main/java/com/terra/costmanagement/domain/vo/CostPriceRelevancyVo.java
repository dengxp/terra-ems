package com.terra.costmanagement.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.terra.common.annotation.Excel;
import com.terra.common.core.domain.BaseEntity;
import com.terra.costmanagement.domain.CostPriceRelevancy;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 单价关联对象 cost_price_relevancy
 *
 * @author terra
 * @date 2024-11-09
 */
@Data
public class CostPriceRelevancyVo extends CostPriceRelevancy {
    private BigDecimal price;
    private String electricityType;

}
