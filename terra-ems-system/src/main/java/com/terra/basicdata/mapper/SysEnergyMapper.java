package com.terra.basicdata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.terra.basicdata.domain.SysEnergy;
import com.terra.basicdata.domain.vo.EnergyTypeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * energyMapper接口
 *
 * @author ruoyi
 * @date 2020-02-12
 */
public interface SysEnergyMapper extends BaseMapper<SysEnergy>
{
    /**
     * 查询能源类型下拉框
     *
     * @param
     * @return 结果
     */
    List getenerclassname();
    /**
     * 查询energy
     *
     * @param
     * @return energy
     */
    SysEnergy selectSysEnergyById(Integer enerid);

    /**
     * 查询energy列表
     *
     * @param sysEnergy energy
     * @return energy集合
     */
    List<SysEnergy> selectSysEnergyList(SysEnergy sysEnergy);

    /**
     * 新增energy
     *
     * @param sysEnergy energy
     * @return 结果
     */
    int insertSysEnergy(SysEnergy sysEnergy);

    /**
     * 修改energy
     *
     * @param sysEnergy energy
     * @return 结果
     */
    int updateSysEnergy(SysEnergy sysEnergy);

    /**
     * 删除energy
     *
     * @param
     * @return 结果
     */
    int deleteSysEnergyById(Integer enerid);

    /**
     * 批量删除energy
     *
     * @param
     * @return 结果
     */
    int deleteSysEnergyByIds(Integer[] enerids);
    /**
     * 通过能源类型名称查询 能源类型id
     */
    Integer getEnerClassid(String enerclassname);
    /**
     * 查询一样的能源名称有几个 能源名称唯一校验
     */
    int selectSameEnergyNameNum(String enername);
    /**
     * 修改的时候查询一样能源名称的id
     */
    Integer selectIdByName(String enername);
    /**
     * 通过能源id查询单价信息
     */
    Integer getPriceCountByEnerid(SysEnergy sysEnergy);
    /**
     * 增加单价信息
     */
    Integer insertEnergyPrice(SysEnergy sysEnergy);
    /**
     * 修改单价信息
     */
    Integer updateEnergyPrice(SysEnergy sysEnergy);
    /**
     * 通过能源id查折标系数num
     */
    Integer getCoefficientCountByEnerid(Integer enerid);
    /**
     * 增加折标系数信息
     */
    Integer insertEnergyCoefficient(SysEnergy sysEnergy);
    /**
     * 修改折标系数信息
     */
    Integer updateEnergyCoefficient(SysEnergy sysEnergy);

    /**
     * 查询所有能源类型信息
     *
     * @return 所有能源类型
     */
    List<EnergyTypeModel> listAllEnergyType();

    Page<SysEnergy> selectSysEnergyPage(@Param("sysEnergy") SysEnergy sysEnergy, @Param("page")Page<?> page);
}
