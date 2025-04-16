package com.terra.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.terra.system.domain.SysNameConfig;
import com.terra.system.mapper.SysNameConfigMapper;
import com.terra.system.service.ISysNameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统名称配置Service业务层处理
 *
 * @author terra
 * @date 2024-11-05
 */
@Service
public class SysNameConfigServiceImpl extends ServiceImpl<SysNameConfigMapper, SysNameConfig> implements ISysNameConfigService {
    @Autowired
    private SysNameConfigMapper sysNameConfigMapper;

    @Override
    public SysNameConfig getSysNameConfig() {
        LambdaQueryWrapper<SysNameConfig> wrapper = new LambdaQueryWrapper<>();
        return sysNameConfigMapper.selectOne(wrapper);
    }
}
