package com.terra.peakvalley.domain.vo.peakvalley;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.terra.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 尖峰平谷按小时统计报表 vo
 */
@Data
@NoArgsConstructor
@ApiModel(value = "尖峰平谷按小时统计报表 vo", description = "尖峰平谷按小时统计报表 vo")
public class PeakValleyHourDataVO {

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH")
    @ApiModelProperty(value = "时间")
    @Excel(name = "时间")
    private Date time;

    /**
     * 尖费用
     */
    @ApiModelProperty(value = "尖费用")
    @Excel(name = "尖费用")
    private BigDecimal sharpFee;

    /**
     * 尖电量
     */
    @ApiModelProperty(value = "尖电量")
    @Excel(name = "尖电量")
    private BigDecimal sharpPower;

    /**
     * 峰费用
     */
    @ApiModelProperty(value = "峰费用")
    @Excel(name = "峰费用")
    private BigDecimal peakFee;

    /**
     * 峰电量
     */
    @ApiModelProperty(value = "峰电量")
    @Excel(name = "峰电量")
    private BigDecimal peakPower;

    /**
     * 平费用
     */
    @ApiModelProperty(value = "平费用")
    @Excel(name = "平费用")
    private BigDecimal flatFee;

    /**
     * 平电量
     */
    @ApiModelProperty(value = "平电量")
    @Excel(name = "平电量")
    private BigDecimal flatPower;

    /**
     * 谷费用
     */
    @ApiModelProperty(value = "谷费用")
    @Excel(name = "谷费用")
    private BigDecimal valleyFee;

    /**
     * 谷电量
     */
    @ApiModelProperty(value = "谷电量")
    @Excel(name = "谷电量")
    private BigDecimal valleyPower;

    /**
     * 总费用
     */
    @ApiModelProperty(value = "总费用")
    @Excel(name = "总费用")
    private BigDecimal totalFee;

    /**
     * 总电量
     */
    @ApiModelProperty(value = "总电量")
    @Excel(name = "总电量")
    private BigDecimal totalPower;


    public PeakValleyHourDataVO(Date time, BigDecimal sharpFee, BigDecimal sharpPower, BigDecimal peakFee,
                                BigDecimal peakPower, BigDecimal flatFee, BigDecimal flatPower, BigDecimal valleyFee,
                                BigDecimal valleyPower) {
        this.time = time;
        this.sharpFee = sharpFee;
        this.sharpPower = sharpPower;
        this.peakFee = peakFee;
        this.peakPower = peakPower;
        this.flatFee = flatFee;
        this.flatPower = flatPower;
        this.valleyFee = valleyFee;
        this.valleyPower = valleyPower;
        this.totalPower = sharpPower.add(peakPower).add(valleyPower).add(flatPower);
        this.totalFee = sharpFee.add(peakFee).add(valleyFee).add(flatFee);
    }
}