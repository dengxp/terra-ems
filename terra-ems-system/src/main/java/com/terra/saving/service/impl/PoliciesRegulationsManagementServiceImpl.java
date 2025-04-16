package com.terra.saving.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.terra.common.constant.CommonConst;
import com.terra.common.exception.ServiceException;
import com.terra.common.utils.PageUtils;
import com.terra.common.utils.SecurityUtils;
import com.terra.common.utils.bean.BeanUtils;
import com.terra.common.utils.id.IdGenUtil;
import com.terra.saving.domain.dto.PoliciesRegulationsDTO;
import com.terra.saving.domain.dto.PoliciesRegulationsManagementPageDTO;
import com.terra.saving.domain.entity.PoliciesRegulationsManagement;
import com.terra.saving.domain.vo.PoliciesRegulationsManagementDetailVO;
import com.terra.saving.domain.vo.PoliciesRegulationsManagementPageVO;
import com.terra.saving.mapper.PoliciesRegulationsManagementMapper;
import com.terra.saving.service.IPoliciesRegulationsManagementService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * 政策法规Service业务层处理
 *
 * @author terra
 * @date 2024-12-26
 */
@Service
public class PoliciesRegulationsManagementServiceImpl extends ServiceImpl<PoliciesRegulationsManagementMapper, PoliciesRegulationsManagement> implements IPoliciesRegulationsManagementService {

    /**
     * 政策法规-列表查询
     */

    @Override
    public Page<PoliciesRegulationsManagementPageVO> getPageList(PoliciesRegulationsManagementPageDTO pageDTO) {
        Page<PoliciesRegulationsManagementPageVO> pageInfo = PageUtils.getPageInfo(PoliciesRegulationsManagementPageVO.class);
        return baseMapper.getPageList(pageInfo, pageDTO);
    }

    /**
     * 政策法规-查询详情
     */
    @Override
    public PoliciesRegulationsManagementDetailVO getDetail(Long id) {
        PoliciesRegulationsManagement policiesRegulationsManagement = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(policiesRegulationsManagement)) {
            return null;
        }
        PoliciesRegulationsManagementDetailVO detailVO = new PoliciesRegulationsManagementDetailVO();
        BeanUtils.copyProperties(policiesRegulationsManagement, detailVO);
        return detailVO;
    }



    /**
     * 政策法规-新增
     */
    @Override
    public void add(PoliciesRegulationsDTO addDTO) {

        long pid = IdGenUtil.nextLongId();
        String username = SecurityUtils.getUsername();
        PoliciesRegulationsManagement policiesRegulationsManagement = new PoliciesRegulationsManagement();
        policiesRegulationsManagement.setId(pid);
        policiesRegulationsManagement.setDelFlag(0);
        policiesRegulationsManagement.setCreateBy(username);
        BeanUtils.copyProperties(addDTO, policiesRegulationsManagement);
        // 新增政策法规
        baseMapper.insert(policiesRegulationsManagement);


    }

    /**
     * 政策法规-更新
     */
    @Override
    public void edit(PoliciesRegulationsDTO editDTO) {
        if (ObjectUtils.isEmpty(editDTO.getId())) {
            throw new ServiceException("政策ID不能为空");
        }
        // 获取政策法规
        PoliciesRegulationsManagement policiesRegulationsManagement = baseMapper.selectById(editDTO.getId());
        if (ObjectUtils.isEmpty(policiesRegulationsManagement)) {
            throw new ServiceException("未找到对应实体");
        }
        BeanUtils.copyProperties(editDTO, policiesRegulationsManagement);

        baseMapper.updateById(policiesRegulationsManagement);
    }

    /**
     * 政策法规-删除
     */
    @Override
    public void delete(Long id) {
        // 获取政策法规
        PoliciesRegulationsManagement policiesRegulationsManagement = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(policiesRegulationsManagement)) {
            throw new ServiceException("未找到对应实体");

        }
        policiesRegulationsManagement.setDelFlag(CommonConst.DEL_FLAG_1);
        baseMapper.updateById(policiesRegulationsManagement);

    }

}
