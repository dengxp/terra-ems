package com.terra.basicdata.mapper;


import com.terra.basicdata.domain.MeterAnnex;

import java.util.List;

/**
 * 计量器具档案附件Mapper接口
 * 
 * @author zhaowei
 * @date 2020-02-14
 */
public interface MeterAnnexMapper 
{
    /**
     * 查询计量器具档案附件
     * 
     * @param id 计量器具档案附件ID
     * @return 计量器具档案附件
     */
    public MeterAnnex selectMeterAnnexById(String id);

    /**
     * 查询计量器具档案附件列表
     * 
     * @param meterAnnex 计量器具档案附件
     * @return 计量器具档案附件集合
     */
    public List<MeterAnnex> selectMeterAnnexList(MeterAnnex meterAnnex);

    /**
     * 新增计量器具档案附件
     * 
     * @param meterAnnex 计量器具档案附件
     * @return 结果
     */
    public int insertMeterAnnex(MeterAnnex meterAnnex);

    /**
     * 修改计量器具档案附件
     * 
     * @param meterAnnex 计量器具档案附件
     * @return 结果
     */
    public int updateMeterAnnex(MeterAnnex meterAnnex);

    /**
     * 删除计量器具档案附件
     * 
     * @param id 计量器具档案附件ID
     * @return 结果
     */
    public int deleteMeterAnnexById(String id);

    /**
     * 批量删除计量器具档案附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMeterAnnexByIds(String[] ids);
}
