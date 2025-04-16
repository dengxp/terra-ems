package com.terra.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.terra.system.domain.SysNameConfig;

/**
 * 系统名称配置Service接口
 *
 * @author terra
 * @date 2024-11-05
 */
public interface ISysNameConfigService extends IService<SysNameConfig> {

    SysNameConfig getSysNameConfig();
}
