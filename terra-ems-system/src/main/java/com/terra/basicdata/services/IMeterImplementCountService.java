package com.terra.basicdata.services;


import com.terra.basicdata.domain.MeterImplementCount;

import java.util.List;

/**
 * 计量器具统计查询Service接口
 * 
 * @author zhaowei
 * @date 2020-02-21
 */
public interface IMeterImplementCountService 
{
    /**
     * 查询计量器具统计查询
     * 
     * @param code 计量器具统计查询ID
     * @return 计量器具统计查询
     */
    public MeterImplementCount selectMeterImplementCountById(String code);

    /**
     * 查询计量器具统计查询列表
     * 
     * @param meterImplementCount 计量器具统计查询
     * @return 计量器具统计查询集合
     */
    public List<MeterImplementCount> selectMeterImplementCountList(MeterImplementCount meterImplementCount);

    /**
     * 新增计量器具统计查询
     * 
     * @param meterImplementCount 计量器具统计查询
     * @return 结果
     */
    public int insertMeterImplementCount(MeterImplementCount meterImplementCount);

    /**
     * 修改计量器具统计查询
     * 
     * @param meterImplementCount 计量器具统计查询
     * @return 结果
     */
    public int updateMeterImplementCount(MeterImplementCount meterImplementCount);

    /**
     * 批量删除计量器具统计查询
     * 
     * @param codes 需要删除的计量器具统计查询ID
     * @return 结果
     */
    public int deleteMeterImplementCountByIds(String[] codes);

    /**
     * 删除计量器具统计查询信息
     * 
     * @param code 计量器具统计查询ID
     * @return 结果
     */
    public int deleteMeterImplementCountById(String code);
}
