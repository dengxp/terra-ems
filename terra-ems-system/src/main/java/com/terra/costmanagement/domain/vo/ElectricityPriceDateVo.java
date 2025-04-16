package com.terra.costmanagement.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.terra.common.annotation.Excel;
import com.terra.common.core.domain.BaseEntity;
import com.terra.peakvalley.domain.ElectricityPrice;
import com.terra.peakvalley.domain.ElectricityPriceDate;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 尖峰平谷电价时间段对象 electricity_price_date
 *
 * @author terra
 * @date 2024-10-10
 */
@Data
public class ElectricityPriceDateVo extends ElectricityPriceDate {
   List<ElectricityPrice>itemList;
}
