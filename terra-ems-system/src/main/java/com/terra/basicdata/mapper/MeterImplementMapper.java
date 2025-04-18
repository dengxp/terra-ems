package com.terra.basicdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.terra.basicdata.domain.MeterImplement;
import com.terra.basicdata.domain.MeterImplementExcel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计量器具档案维护Mapper接口
 * 
 * @author zhaowei
 * @date 2020-02-12
 */
public interface MeterImplementMapper extends BaseMapper<MeterImplement>
{
    /**
     * 查询计量器具档案维护
     * 
     * @param id 计量器具档案维护ID
     * @return 计量器具档案维护
     */
    public MeterImplement selectMeterImplementById(String id);
    /**
     * 查询计量器具档案维护
     *
     * @param meterImplement 计量器具档案维护编号
     * @return 计量器具档案维护
     */
    public MeterImplement selectMeterImplementByCode(MeterImplement meterImplement);

    /**
     * 查询计量器具档案维护列表
     * 
     * @param meterImplement 计量器具档案维护
     * @return 计量器具档案维护集合
     */
    public List<MeterImplement> selectMeterImplementList(MeterImplement meterImplement);
    /**
     * 查询计量器具档案维护导出列表，其中字典字段在SQL中进行翻译
     *
     * @param meterImplement 计量器具档案维护
     * @return 计量器具档案维护集合
     */
    public List<MeterImplementExcel> exectMeterImplementList(MeterImplement meterImplement);

    /**
     * 新增计量器具档案维护
     * 
     * @param meterImplement 计量器具档案维护
     * @return 结果
     */
    public int insertMeterImplement(MeterImplement meterImplement);

    /**
     * 修改计量器具档案维护
     * 
     * @param meterImplement 计量器具档案维护
     * @return 结果
     */
    public int updateMeterImplement(MeterImplement meterImplement);

    /**
     * 删除计量器具档案维护
     * 
     * @param id 计量器具档案维护ID
     * @return 结果
     */
    public int deleteMeterImplementById(String id);

    /**
     * 批量删除计量器具档案维护
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMeterImplementByIds(String[] ids);

    /**
     * 根据id集合查询计量器具信息
     *
     * @param meterIdList   计量器具id
     * @return
     */
    List<MeterImplement> listMeterImplementByIds(@Param("meterIdList") List<String> meterIdList);

    MeterImplement selectByNodeIdIndexId(@Param("nodeId") String nodeId, @Param("indexId") String indexId);

    List<MeterImplement> listMeterImplByInstallLocation(@Param("installactionLocation") String installactionLocation);

    /**
     * 根据节点id查询计量器具信息
     *
     * @param nodeId
     * @return
     */
    List<MeterImplement> selectByNodeId(@Param("nodeId") String nodeId);
}
