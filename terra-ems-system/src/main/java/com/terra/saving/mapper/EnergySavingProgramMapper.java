package com.terra.saving.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.terra.saving.domain.entity.EnergySavingProgram;

/**
 * 节能项目管理
 * Mapper接口
 *
 * @author terra
 * @date 2024-12-26
 */
public interface EnergySavingProgramMapper extends BaseMapper<EnergySavingProgram> {
    /**
     * 查询
     * 节能项目管理
     *
     * @param id 节能项目管理
     *           主键
     * @return 节能项目管理
     */
    EnergySavingProgram selectEnergySavingProgramById(Long id);



}
