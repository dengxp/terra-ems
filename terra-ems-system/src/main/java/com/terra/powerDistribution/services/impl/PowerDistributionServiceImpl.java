package com.terra.powerDistribution.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.terra.basicdata.domain.MeterImplement;
import com.terra.basicdata.mapper.MeterImplementMapper;
import com.terra.common.utils.StringUtils;
import com.terra.powerDistribution.domain.PowerDistribution;
import com.terra.powerDistribution.mapper.PowerDistributionMapper;
import com.terra.powerDistribution.services.IPowerDistributionService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PowerDistributionServiceImpl extends ServiceImpl<PowerDistributionMapper, PowerDistribution> implements IPowerDistributionService {

    @Resource
    private MeterImplementMapper meterImplementMapper;

    @Override
    public List<PowerDistribution> selectPowerDistributionList(PowerDistribution powerDistribution) {
        LambdaQueryWrapper<PowerDistribution> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(powerDistribution.getCode())){
            queryWrapper.like(PowerDistribution::getCode, powerDistribution.getCode());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getName())){
            queryWrapper.like(PowerDistribution::getName, powerDistribution.getName());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getPrincipals())){
            queryWrapper.like(PowerDistribution::getPrincipals, powerDistribution.getPrincipals());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getPrincipalsTel())){
            queryWrapper.like(PowerDistribution::getPrincipalsTel, powerDistribution.getPrincipalsTel());
        }
        return list(queryWrapper);
    }

    @Override
    public Page<PowerDistribution> pageList(PowerDistribution powerDistribution, Page<PowerDistribution> page) {
        LambdaQueryWrapper<PowerDistribution> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(powerDistribution.getCode())){
            queryWrapper.like(PowerDistribution::getCode, powerDistribution.getCode());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getName())){
            queryWrapper.like(PowerDistribution::getName, powerDistribution.getName());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getPrincipals())){
            queryWrapper.like(PowerDistribution::getPrincipals, powerDistribution.getPrincipals());
        }
        if (StringUtils.isNotEmpty(powerDistribution.getPrincipalsTel())){
            queryWrapper.like(PowerDistribution::getPrincipalsTel, powerDistribution.getPrincipalsTel());
        }
        return page(page, queryWrapper);
    }

    @Override
    public int deleteByIds(List<String> idList) {
        return baseMapper.deletePowerDistributionByIds(idList);
    }

}
