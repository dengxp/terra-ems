package com.terra.costmanagement.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.terra.common.annotation.Excel;
import com.terra.common.core.domain.BaseEntity;
import com.terra.costmanagement.domain.CostPriceTactics;
import com.terra.costmanagement.domain.CostPriceTacticsItem;
import com.terra.spikesandvalleys.domain.SpikesAndValleysItem;
import lombok.Data;

import java.util.List;

/**
 * 成本策略对象 vo
 *
 *
 */
@Data
public class CostPriceTacticsVo extends CostPriceTactics {
    List<CostPriceTacticsItem> itemList;

}
