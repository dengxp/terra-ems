package com.terra.model.domain;

import com.terra.common.annotation.Excel;
import com.terra.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 采集参数模板对象 daq_template
 *
 * @author ruoyi
 * @date 2020-02-08
 */
public class DaqTemplate extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  private String id;

  /**
   * 参数编码
   */
  @Excel(name = "参数编码")
  private String code;

  @Excel(name = "采集编码")
  private String gatewayKey;
  /**
   * 参数名称
   */
  @Excel(name = "参数名称")
  private String name;

  /**
   * 参数所属类型
   */
  @Excel(name = "参数所属类型")
  private String deviceType;

  @Excel(name = "单位")
  private String unit;

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getDeviceType() {
    return deviceType;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("id", getId())
        .append("code", getCode())
        .append("name", getName())
        .append("deviceType", getDeviceType())
        .append("unit", getUnit())
        .toString();
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getGatewayKey() {
    return gatewayKey;
  }

  public void setGatewayKey(String gatewayKey) {
    this.gatewayKey = gatewayKey;
  }
}
