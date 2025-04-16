package com.terra.spikesandvalleys.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.terra.common.annotation.Excel;
import com.terra.common.core.domain.BaseEntity;
import com.terra.spikesandvalleys.domain.SpikesAndValleysItem;
import com.terra.spikesandvalleys.domain.SpikesAndValleysScheme;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 尖峰平谷时间段明细对象 spikes_and_valleys_scheme
 *
 * @author terra
 * @date 2024-10-29
 */
@Data
public class SpikesAndValleysSchemeVo extends SpikesAndValleysScheme {
    List<SpikesAndValleysItem> itemList;
}
