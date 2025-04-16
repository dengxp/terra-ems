package com.terra.saving.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.terra.common.annotation.DataSource;
import com.terra.common.enums.DataSourceType;
import com.terra.saving.domain.dto.PoliciesRegulationsManagementPageDTO;
import com.terra.saving.domain.entity.PoliciesRegulationsManagement;
import com.terra.saving.domain.vo.PoliciesRegulationsManagementPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 政策法规Mapper接口
 *
 * @author terra
 * @date 2024-12-26
 */
@Mapper
public interface PoliciesRegulationsManagementMapper extends BaseMapper<PoliciesRegulationsManagement> {


    /**
     * 政策法规-列表分页查询
     */
    Page<PoliciesRegulationsManagementPageVO> getPageList(Page<PoliciesRegulationsManagementPageVO> pageInfo, @Param("dto") PoliciesRegulationsManagementPageDTO pageDTO);


}
